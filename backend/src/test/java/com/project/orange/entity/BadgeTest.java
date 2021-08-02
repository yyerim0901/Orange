package com.project.orange.entity;

import com.project.orange.repository.BadgesUsersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BadgeTest {
    @Autowired
    BadgesUsersRepository badgesUsersRepository;

    @Test
    void insert(){
        //given
        BadgesUsers bu = new BadgesUsers();
        bu.setBadgeId(0L);
        bu.setBadgeCount(1);
        bu.setUserId(0L);
        bu.setId(0L);

        //when
        BadgesUsers savedBu = badgesUsersRepository.save(bu);

        //then
        Long buId = 0L;
        assertEquals(buId, savedBu.getId());
    }
}
