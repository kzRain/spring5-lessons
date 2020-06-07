package com.example.demo.service

import com.example.demo.model.Point
import com.example.demo.repo.PointRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PointServiceTest {

    @Autowired
    lateinit var pointService: PointService

    @Autowired
    lateinit var pointRepository: PointRepository

    @Test
    fun `get all free points`() {
        val points = pointService.getAllFree()
        assertNotNull(points)
        assertFalse(points!!.isEmpty())
    }

    @Test
    fun `fill full point and check it`() {
        val point = pointRepository.save(Point(num="test",  address = "Almaty", boxNum = 30, boxBusy = 0))
        pointService.addBoxToPoint(point, 30)
        val newPoint = pointRepository.findById(point.id!!).get()
        val points = pointService.getAllFree()
        assertFalse(points!!.contains(newPoint))
        pointRepository.deleteById(point.id!!)
    }
}