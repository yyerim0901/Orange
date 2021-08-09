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
    @JoinColumn(name = "from")
    private Users from;

    @ManyToOne
    @JoinColumn(name = "to")
    private Users to;

}
