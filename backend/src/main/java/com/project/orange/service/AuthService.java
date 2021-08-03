package com.project.orange.service;

import com.project.orange.entity.user.Users;

public interface AuthService {
    void signUpUser(Users user);

    Users loginUser(String username, String password) throws Exception;
}
