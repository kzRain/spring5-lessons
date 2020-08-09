package kz.cf.spring5.point.repo

import kz.cf.spring5.point.model.Box
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BoxRepository:JpaRepository<Box, Long> {
    @Query("from Box b where b.isBusy = :isBusy")
    fun findByIsBusy(isBusy: Boolean): List<Box>
}