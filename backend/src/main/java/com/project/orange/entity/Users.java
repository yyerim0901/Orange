package com.project.orange.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED) //접근 권한을 최소화
@ToString
@Getter
@Entity
public class Users {

    @Id
    @Column(name = "user_id")
    private Long userid;
    private String email;
    private String nickname;

    //단축키 alt+insert
    @Builder
    public Users(Long userid, String email, String nickname) {
        this.userid = userid;
        this.email = email;
        this.nickname = nickname;
    }
}
