package com.project.orange.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name="badges")
public class Badges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="badge_id")
    private Long badgeId;

    @Column(name="badge_title", length=45)
    private String badgeTitle;

    @Column(name="badge_describe", length=45)
    private String badgeDescribe;

    @Lob
    private String badgeImage;

//    뱃지에서 뱃지 타입에 접근
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "badge_type_id")
    private BadgeTypes badgeTypeTd;
}
