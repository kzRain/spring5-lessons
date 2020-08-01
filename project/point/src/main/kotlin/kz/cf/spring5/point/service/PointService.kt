package kz.cf.spring5.point.service

import kz.cf.spring5.point.model.Box
import org.springframework.stereotype.Service

interface PointService {
    fun save(box:Box): Box
}

@Service
class PointServiceImpl: PointService {
    override fun save(box: Box): Box {
        TODO("Not yet implemented")
    }

}