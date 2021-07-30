package com.project.orange.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class FollowerFollowing {

    @Id
    @Column(name = "id")
    private Long followId;
    @Column(name = "from")
    private Long from;
    @Column(name = "to")
    private Long to;

    @Builder
    public FollowerFollowing(Long followId, Long from, Long to) {
        this.followId = followId;
        this.from = from;
        this.to = to;
    }
}
