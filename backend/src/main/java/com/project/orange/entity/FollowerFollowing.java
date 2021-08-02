package com.project.orange.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class FollowerFollowing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long followId;
    @Column(name = "from")
    private Long from;
    @Column(name = "to")
    private Long to;

    //Users와 1:N , N:1 관계...

    @Builder
    public FollowerFollowing(Long followId, Long from, Long to) {
        this.followId = followId;
        this.from = from;
        this.to = to;
    }
}
