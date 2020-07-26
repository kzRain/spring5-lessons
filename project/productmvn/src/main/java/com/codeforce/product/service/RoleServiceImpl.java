package com.codeforce.product.service;

import com.codeforce.product.model.Role;
import com.codeforce.product.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;


    @Override
    public Role getRoleByID(Role r) {
        Optional<Role> role = roleRepository.findById(r.getId());
        if (role.isPresent()) {
            return role.get();
        }
        return null;
    }
}
