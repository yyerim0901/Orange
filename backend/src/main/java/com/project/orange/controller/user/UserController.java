package com.project.orange.controller.user;

import com.project.orange.entity.user.RequestLoginUser;
import com.project.orange.entity.user.Users;
import com.project.orange.service.user.AuthService;


import com.project.orange.service.user.CookieUtil;
import com.project.orange.service.user.JwtUtil;
import com.project.orange.service.user.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
//@CrossOrigin("*")
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CookieUtil cookieUtil;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/signup")
    public ResponseEntity<String> signUpUser(@RequestBody Users user) {
        try {
            authService.signUpUser(user);
            return new ResponseEntity<String>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("fail",HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RequestLoginUser loginUser,
                                        HttpServletRequest req,
                                        HttpServletResponse res){
        try {
            final Users user = authService.loginUser(loginUser.getEmail(), loginUser.getPassword());
            System.out.println("유저 정보 : "+user.toString());
            final String token = jwtUtil.generateToken(user);
            System.out.println("토큰 정보"+token);
            final String refreshJwt = jwtUtil.generateRefreshToken(user);
            System.out.println("refresh 토큰 정보"+token);
            Cookie accessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, token);
            Cookie refreshToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, refreshJwt);
            redisUtil.setDataExpire(refreshJwt, user.getEmail(), JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);
            res.addCookie(accessToken);
            res.addCookie(refreshToken);
            return new ResponseEntity<>("success",HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("error",HttpStatus.NOT_FOUND);
        }
    }

}
