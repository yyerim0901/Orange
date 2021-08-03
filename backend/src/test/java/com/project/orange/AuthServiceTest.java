package com.project.orange;

import com.project.orange.entity.user.RequestLoginUser;
import com.project.orange.entity.user.Users;
import com.project.orange.service.AuthService;
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
        user.setEmail("403.forbidden@kakao.com");
        user.setNickname("ff");
        user.setPassword("a");
        user.setProfileImagePath("jjjj");
        user.setSalt(null);
        user.setToken("helloimtoken");

        authService.signUpUser(user);
    }

    @Test
    public void login(){
        RequestLoginUser loginUser = new RequestLoginUser("user222","a1234");
        try{
            authService.loginUser(loginUser.getNickname(),loginUser.getPassword());
            log.info("로그인 성공");
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
