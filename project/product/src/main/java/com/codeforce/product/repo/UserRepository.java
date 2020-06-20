package com.codeforce.product.repo;

import com.codeforce.product.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findAllById(Long id);

}
