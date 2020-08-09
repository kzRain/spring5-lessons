package kz.cf.spring5.point.web

import kz.cf.spring5.point.model.Box
import kz.cf.spring5.point.model.dto.Container
import kz.cf.spring5.point.service.PointService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/api")
class PointController {

    @Autowired
    lateinit var pointService: PointService
    @PostMapping("sendContainer")
    fun newContainer(container: Container): List<Box> {
        val result = pointService.fillBoxes(container)
        return result
    }


}