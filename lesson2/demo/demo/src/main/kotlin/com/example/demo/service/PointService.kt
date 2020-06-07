package com.example.demo.service

import com.example.demo.model.Point
import com.example.demo.repo.PointRepository
import org.springframework.stereotype.Service

interface PointService {
    fun getAllFree(): MutableList<Point>?
    fun addBoxToPoint(point: Point, busyBox: Int)
}

@Service
class PointServiceImpl(
        private val pointRepository: PointRepository
): PointService {
    override fun addBoxToPoint(point: Point, busyBox: Int) {
        point.boxBusy += busyBox
        pointRepository.save(point)
    }

    override fun getAllFree() = pointRepository.findAllFree()


}
