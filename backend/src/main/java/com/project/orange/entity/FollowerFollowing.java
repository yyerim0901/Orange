package com.project.orange.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
public class FollowerFollowing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long followId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users fromUser;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users toUser;


//    @Builder
//    public FollowerFollowing(Long followId, Long from, Long to) {
//        this.followId = followId;
//        this.from = from;
//        this.to = to;
//    }
}
