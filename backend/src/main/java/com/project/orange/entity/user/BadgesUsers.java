package com.project.orange.entity.user;

import com.project.orange.entity.badge.Badges;
import com.project.orange.entity.user.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "badges_users")
@Builder
public class BadgesUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "badge_count")
    private Integer badgeCount;

    @Column(name = "represent_badge")
    private boolean representBadge;

//    테스트를 위한 코드
    @Column(name = "badge_id")
    private Long badge;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "badge_id")
//    private Badges badge;

//    테스트를 위한 코드
    @Column(name = "user_id")
    private Long user;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private Users user;
}
