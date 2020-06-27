package com.codeforce.product.repo;

import com.codeforce.product.model.LogsDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsDBRepo extends JpaRepository<LogsDB, Long> {
}
