package kz.cf.spring5.point.service

import kz.cf.spring5.point.model.Box
import kz.cf.spring5.point.model.Config
import kz.cf.spring5.point.model.dto.Container
import kz.cf.spring5.point.model.dto.Pack
import kz.cf.spring5.point.model.enums.BoxType
import kz.cf.spring5.point.model.enums.DistrType
import kz.cf.spring5.point.repo.ConfigRepository
import kz.cf.spring5.point.web.PointController
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
import org.springframework.test.util.ReflectionTestUtils
import org.springframework.ui.ExtendedModelMap

@Profile("test")
@SpringBootTest
class PointServiceTest {

    @Autowired
    lateinit var pointService: PointService

    @Autowired
    lateinit var configService: ConfigService

    @Autowired
    lateinit var configRepository: ConfigRepository

    var config: Config? = null;

    @BeforeEach
    fun SetUp() {
        configRepository.deleteAll()
        config = configService.save(Config(name = "NAME", value = "POINT1"))
        config = configService.save(Config(name = "CAPACITY", value = "10"))
        config = configService.save(Config(name = "DISTRIBUTION", value = "ASCEDING"))
        pointService.initPoint()
    }

    @Test
    fun `Инициализация станции`() {
        assert(config!!.id != null)
        val configs = configRepository.findAll()
        assert(configs.size > 0)
    }

    @Test
    fun `создание сущности Box`() {
        val box = pointService.save(Box(num = "10", type = BoxType.STANDART, isBusy = false))
        assert(box.id != null)
    }

    @Test
    fun `Передаем информацию о станции`() {
        val configs = configRepository.findAll()
        assert(configs.size > 0)
        val pointInfo = pointService.getInfo()
        assert(pointInfo.name.equals("POINT1"))
        assert(pointInfo.freeBoxes!! > 0)
    }

    @Test
    fun `Получение информации о посылке`() {
        val prevFreeSize = pointService.getInfo().freeBoxes
        val pointController = PointController()
        ReflectionTestUtils.setField(pointController, "pointService", pointService)
        val packs = mutableListOf<Pack>()
        packs.add(Pack(num = "1"))
        val container = Container(num = "1", packs = packs)
        val uiModel = ExtendedModelMap()
        uiModel.addAttribute("boxes", pointController.newContainer(container))

        val boxes = uiModel["boxes"] as List<Box>
        assert(boxes.size > 0)
        Assertions.assertEquals(pointService.getInfo().freeBoxes!! + 1, prevFreeSize)
    }

    @Test
    fun `Тестирование распределения пакетов`() {
        val pointInfo = pointService.getInfo()
        if (pointInfo.freeBoxes!! < pointInfo.capacity!!) {
            val boxes = pointService.getFreeBoxes()
            var isFound = false
            if (pointInfo.distrType.equals(DistrType.ASCEDING)) {
                for (next in boxes) if (next.num.equals("1")) {
                    isFound = true
                    break
                }
            } else if (pointInfo.distrType.equals(DistrType.DESCENT)) {
                for (next in boxes) if (next.num.equals(pointInfo.capacity.toString())) {
                    isFound = true
                    break
                }
            }
            assert(!isFound)
        }
    }
}