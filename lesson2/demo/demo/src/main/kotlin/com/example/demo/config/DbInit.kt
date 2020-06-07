package com.example.demo.config

import com.example.demo.model.Point
import com.example.demo.repo.PointRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class DbInit {

    @Autowired
    lateinit var pointRepository: PointRepository

    @PostConstruct
    fun pointInit() {
        val point = Point(num="123",  address = "Almaty", boxNum = 30, boxBusy = 30)
        pointRepository.save(point)
        pointRepository.save(Point(num="234",  address = "Almaty", boxNum = 70, boxBusy = 30))
    }
}