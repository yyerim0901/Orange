package com.project.orange.entity;

import javax.persistence.*;

@Entity
@Table(name="badges")
public class Badges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="badge_id")
    private Long badge_id;

    @Column(name="badge_title", length=45)
    private String badge_title;

    @Column(name="badge_describe", length=45)
    private String badge_describe;

    @Lob
    private String badge_image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "badge_type_id")
    private BadgeTypes badge_type_id;
}
