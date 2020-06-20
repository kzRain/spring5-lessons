package com.codeforce.product.service;

import com.codeforce.product.model.Role;
import com.codeforce.product.model.User;
import com.codeforce.product.repo.RoleRepository;
import com.codeforce.product.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Override
    public User getUserByID(Long id) {
        Optional<User> user = userRepository.findAllById(id);
        if(user.isPresent()){
            return user.get();//? why get
        }
        return null;
    }

    @Override
    public User addOrUpdateUser(User u) {
        Optional<User> user = userRepository.findAllById(u.getId());
        if(user.isPresent()){
            User chaneUser = user.get();
            chaneUser.setLogin(u.getLogin());
            chaneUser.setRole(u.getRole());

            chaneUser = userRepository.save(chaneUser);
            return chaneUser;
        }else{
            u = userRepository.save(u);
            return u;
        }
    }

    @Override
    public Role getRoleOfUser(User u) {
        Optional<Role> role = roleRepository.findAllById(u.getRole().getId());
        if(role.isPresent()){
            return role.get();
        }
        return null;
    }
}
