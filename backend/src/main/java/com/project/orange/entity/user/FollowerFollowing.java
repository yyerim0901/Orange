package com.project.orange.entity.user;

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
    @JoinColumn//(name = "user_id")
    private Users fromUser;

    @ManyToOne
    @JoinColumn//(name = "user_id")
    private Users toUser;

}
