package com.project.orange.entity;

import com.project.orange.repository.BadgesUsersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BadgeTest {
    @Autowired
    BadgesUsersRepository badgesUsersRepository;

    @Test
    void insert(){
        //given
        BadgesUsers bu = new BadgesUsers();


    }
}
