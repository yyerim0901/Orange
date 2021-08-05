package com.project.orange.entity.user;

import com.project.orange.entity.user.Users;
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
    @JoinColumn(name = "from")
    private Users from;

    @ManyToOne
    @JoinColumn(name = "to")
    private Users to;


//    @Builder
//    public FollowerFollowing(Long followId, Long from, Long to) {
//        this.followId = followId;
//        this.from = from;
//        this.to = to;
//    }
}
