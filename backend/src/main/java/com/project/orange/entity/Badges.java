package com.project.orange.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
@AllArgsConstructor
@Table(name="badges")
public class Badges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "badge_id")
    private Long badgeId;

    @Column(name = "badge_title")
    private String badgeTitle;

    @Column(name = "badge_describe")
    private String badgeDescribe;

    @Lob
    @Column(name = "badge_image")
    private Blob badgeImage;

//    뱃지에서 뱃지 타입에 접근
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "badge_type_id")
    private BadgeTypes badgeType;
}
