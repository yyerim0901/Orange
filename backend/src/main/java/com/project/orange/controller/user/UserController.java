package com.project.orange.controller.user;

import com.project.orange.entity.user.RequestLoginUser;
import com.project.orange.entity.user.Users;
import com.project.orange.service.user.*;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Slf4j
//@CrossOrigin("*")
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

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
            final String token = jwtUtil.generateToken(user);
            System.out.println("토큰 정보"+token);
            final String refreshJwt = jwtUtil.generateRefreshToken(user);
            System.out.println("refresh 토큰 정보"+token);
            Cookie accessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, token);
            Cookie refreshToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, refreshJwt);
            redisUtil.setDataExpire(refreshJwt, user.getEmail(), JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);
            res.addCookie(accessToken);
            res.addCookie(refreshToken);
            return new ResponseEntity<>(res,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("login error",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    @ApiOperation(value = "list",notes = "전체 사용자 리스트를 출력")
    public ResponseEntity<?> list(){
        List<Users> list = userService.userList();

        if(list == null || list.isEmpty()){
            return new ResponseEntity<>("fail to load userList",HttpStatus.NO_CONTENT);
        }else return new ResponseEntity<>(list,HttpStatus.OK);
    }

    ///////////////////////////////////////////////////////////////////////////

    @GetMapping("/userinfo/{userId}")
    public ResponseEntity<?> readUser(@PathVariable Long userId){ //@Param Long userId 로 바뀔 가능성 있음
        Users userInfo = userService.selectAllByUserId(userId);
        if(userInfo == null){
            return new ResponseEntity<>("찾을 수 없는 사용자입니다.",HttpStatus.NO_CONTENT);
        }else return new ResponseEntity<>(userInfo,HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody Users userInfo){
        userService.updateById(userId,userInfo);
        return new ResponseEntity<>("update userInfo success",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        userService.deleteById(userId);
        return new ResponseEntity<>("delete success",HttpStatus.OK);
    }

}
