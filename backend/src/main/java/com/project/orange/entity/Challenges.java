package com.project.orange.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="challenges")
public class Challenges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="challenge_id")
    private Long challengeId;
    @Column(name="manager_id")
    private Long managerId;
    @Column(name="challenge_title")
    private String challengeTitle;
    @Column(name="category_id")
    private Long categoryId;
    @Column(name="period_id")
    private Long periodId;
    @Column(name="start_date")
    private LocalDateTime startDate;
    @Column(name="end_date")
    private LocalDateTime endDate;
    @Column(name="total_point")
    private Integer totalPoint;
    @Column(name="min_members")
    private Integer minMembers;
    @Column(name="max_members")
    private Integer maxMembers;
    @Column(name="current_members")
    private Integer currentMembers;

    @OneToMany
    private List<UsersChallenges> usersChallengesList;

    @OneToMany
    private List<Articles> articlesList;
}
