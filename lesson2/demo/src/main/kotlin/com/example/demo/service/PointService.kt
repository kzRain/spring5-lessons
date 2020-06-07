package com.example.demo.service

import com.example.demo.model.Point
import com.example.demo.repo.PointRepository
import org.springframework.stereotype.Service

interface PointService {
    fun getAllFree(): MutableList<Point>?
}

@Service
class PointServiceImpl(
        private val pointRepository: PointRepository
): PointService {

    override fun getAllFree(): MutableList<Point>? {
        return pointRepository.findAllFree()
    }

}
