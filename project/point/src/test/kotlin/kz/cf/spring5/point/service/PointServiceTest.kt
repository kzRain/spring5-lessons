package kz.cf.spring5.point.service

import kz.cf.spring5.point.model.Box
import kz.cf.spring5.point.model.enums.BoxType
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PointServiceTest {

    @Autowired
    lateinit var pointService: PointService

    @Test
    fun `создание сущности Box`() {
        val box = pointService.save(Box(num="1", type=BoxType.STANDART, isBusy = false))
        assert(box.id != null)
    }
}