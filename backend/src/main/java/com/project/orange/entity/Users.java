package com.project.orange.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;
    private String email;
    private String nickname;
    private String token;
    @Lob
    private String profile_image;

    //일대다 관계는 엔티티를 하나 이상 참조할 수 있으므로, 자바 컬렉션인 Collection, List, Set, Map 중에 하나를 사용해야한다.(p209)
    //@OneToMany는 연관관계의 주인이 될 수 없다.
    //그래서 주인이 아닌 @OneToMany인 애가 주인을 가리키는 용도로 mappedby를 가짐
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<Notifications> notificationsList = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)//하나의 user가 여러 개의 report를 가진다.
    List<Reports> reportsList = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY) //한 명의 user는 여러 개의 comment를 가진다.
    List<Comments> commentsList = new ArrayList<>();

    @OneToMany(mappedBy = "fromUser", fetch = FetchType.LAZY)
    List<FollowerFollowing> followerList = new ArrayList<>();

    @OneToMany(mappedBy = "toUser", fetch = FetchType.LAZY)
    List<FollowerFollowing> followingList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Articles> articlesList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<BadgesUsers> badgesUsersList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<UsersChallenges> usersChallengesList = new ArrayList<>();

}
