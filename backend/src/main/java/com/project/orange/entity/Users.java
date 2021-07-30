package com.project.orange.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@NoArgsConstructor(access = AccessLevel.PROTECTED) //접근 권한을 최소화
@ToString
@Getter
@Entity
public class Users {

    @Id
    @Column(name = "user_id")
    private Long userId;
    private String email;
    private String nickname;

    //단축키 alt+insert
    @Builder
    public Users(Long userId, String email, String nickname) {
        this.userId = userId;
        this.email = email;
        this.nickname = nickname;
    }


}
