package kz.cf.spring5.point.service

import kz.cf.spring5.point.model.Box
import kz.cf.spring5.point.model.dto.Container
import kz.cf.spring5.point.model.dto.Pack
import kz.cf.spring5.point.model.dto.PointInfo
import kz.cf.spring5.point.model.enums.BoxType
import kz.cf.spring5.point.model.enums.DistrType
import kz.cf.spring5.point.repo.BoxRepository
import kz.cf.spring5.point.repo.ConfigRepository
import org.springframework.stereotype.Service

interface PointService {
    fun save(box: Box): Box
    fun getInfo(): PointInfo
    fun fillBoxes(container: Container): List<Box>
    fun initPoint()
    fun getFreeBoxes(): List<Box>
}

@Service
class PointServiceImpl(
        private val boxRepository: BoxRepository,
        private val configRepository: ConfigRepository
) : PointService {
    override fun save(box: Box): Box {
        return boxRepository.save(box)
    }

    override fun getInfo(): PointInfo {
        val pointInfo = PointInfo()
        pointInfo.name = configRepository.findByName("NAME")!!.value
        pointInfo.freeBoxes = boxRepository.findByIsBusy(false).size
        pointInfo.capacity = configRepository.findByName("CAPACITY")?.value?.toInt()
        pointInfo.distrType = if (configRepository.findByName("DISTRIBUTION")!!.value!!.equals(DistrType.ASCEDING.name))
            DistrType.ASCEDING
        else
            DistrType.DESCENT
        return pointInfo
    }

    override fun fillBoxes(container: Container): List<Box> {
        val result = mutableListOf<Box>()
        val freeBoxes = boxRepository.findByIsBusy(false)
        if (container.packs.size <= freeBoxes.size) {
            for (i in 0..container.packs.size - 1) {
                val next = container.packs[i]
                val box = freeBoxes.get(1)
                box.isBusy = true
                box.packInfo = next.toString()
                boxRepository.save(box)
                result.add(box)
            }
        }
        return result
    }

    override fun initPoint() {
        val capacity = configRepository.findByName("CAPACITY")
        if (capacity != null) {
            val countBox = capacity.value!!.toInt()
            for (i in 1..countBox) {
                boxRepository.save(Box(num = i.toString(), type = BoxType.STANDART, isBusy = false))
            }
        }

    }

    override fun getFreeBoxes() = boxRepository.findByIsBusy(false)

}