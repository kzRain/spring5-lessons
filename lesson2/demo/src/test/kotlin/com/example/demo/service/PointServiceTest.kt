package com.example.demo.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PointServiceTest {

    @Autowired
    lateinit var pointService: PointService

    @Test
    fun `get all free points`() {
        val points = pointService.getAllFree()
        assertNotNull(points)
        assertFalse(points!!.isEmpty())
    }
}