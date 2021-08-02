package com.project.orange.entity;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
@Table(name = "badge_types")
public class BadgeTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="badge_type_id")
    private Long badgeTypeId;

    @Column(name="badge_type_name", length=45)
    private String badgeTypeName;


}
