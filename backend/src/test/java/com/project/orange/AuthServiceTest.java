package com.project.orange;

import com.project.orange.entity.user.RequestLoginUser;
import com.project.orange.entity.user.Salt;
import com.project.orange.entity.user.Users;
import com.project.orange.service.user.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Test
    public void signUp(){
        Users user = new Users();
        user.setEmail("test1");
        user.setNickname("test1");
        user.setPassword("1234");
        user.setUsername("test1");

        authService.signUpUser(user);
    }

    @Test
    public void login(){
        RequestLoginUser loginUser = new RequestLoginUser("email","password");
        try{
            authService.loginUser(loginUser.getEmail(),loginUser.getPassword());
            log.info("로그인 성공");
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
