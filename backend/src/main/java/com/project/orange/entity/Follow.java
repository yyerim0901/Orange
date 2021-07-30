package com.project.orange.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class Follow {

    @Id
    @Column(name = "id")
    private Long followId;
    @Column(name = "from")
    private Long fromId;
    @Column(name = "to")
    private Long toId;

    @Builder
    public Follow(Long followId, Long fromId, Long toId) {
        this.followId = followId;
        this.fromId = fromId;
        this.toId = toId;
    }
}
