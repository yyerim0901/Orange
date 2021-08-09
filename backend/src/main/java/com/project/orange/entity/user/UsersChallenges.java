package com.project.orange.entity.user;

import com.project.orange.entity.challenge.Challenges;
import com.project.orange.entity.user.Users;
import lombok.*;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @Column(name="is_manager")
    private boolean isManager;
}
