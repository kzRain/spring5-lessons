package com.codeforce.product.service;

import com.codeforce.product.model.Role;
import com.codeforce.product.model.User;

interface UserService {

    User getUserByID(Long id);
    User addOrUpdateUser(User u);
    Role getRoleOfUser(User u);

}
