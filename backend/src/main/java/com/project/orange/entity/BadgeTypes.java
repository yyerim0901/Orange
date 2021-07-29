package com.project.orange.entity;


import javax.persistence.*;

public class BadgeTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="badge_type_id")
    private Long badge_type_id;

    @Column(name="badge_type_name", length=45)
    private String badge_type_name;


}
