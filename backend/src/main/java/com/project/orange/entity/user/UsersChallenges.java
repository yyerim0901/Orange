package com.project.orange.entity.user;

import com.project.orange.entity.challenge.Challenges;
import com.project.orange.entity.user.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="users_challenges")
public class UsersChallenges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name="user_id")
    @ManyToOne
    private Users user;

    @JoinColumn(name="challenge_id")
    @ManyToOne
    private Challenges challenge;

    @Column(name="point")
    private Integer point;
}
