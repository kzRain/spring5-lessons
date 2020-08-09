package kz.cf.spring5.point.repo

import kz.cf.spring5.point.model.Config
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ConfigRepository:JpaRepository<Config, Long> {
    fun findByName(name: String): Config?
}