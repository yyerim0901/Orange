package com.project.orange.controller;

import com.project.orange.entity.user.Users;
import com.project.orange.service.AuthService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUpUser(@RequestBody Users user) {
        try {
            authService.signUpUser(user);
            return new ResponseEntity<String>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("fail",HttpStatus.NO_CONTENT);
        }
    }

}
