package com.project.orange.service.user;

import com.project.orange.entity.user.Users;
import javassist.NotFoundException;

public interface AuthService {

    void signUpUser(Users user);

    Users loginUser(String username, String password) throws Exception;

}
