package com.example.demo.repo

import com.example.demo.model.Point
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface PointRepository: JpaRepository<Point, Long> {

    @Query("select p from Point p where p.boxNum<>p.boxBusy")
    fun findAllFree(): MutableList<Point>?
}