package com.example.demo.repo;

import com.example.demo.entity.LogsDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsDBRepo extends JpaRepository<LogsDB, Long> {
}
