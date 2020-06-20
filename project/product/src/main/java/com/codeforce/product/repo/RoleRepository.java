package com.codeforce.product.repo;

import com.codeforce.product.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role,Long> {
    Optional<Role> findAllById(Long id);
}
