package com.project.orange.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@AllArgsConstructor
@Entity
@Table(name = "images")
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;

    @Column(name = "article_id")
    private Long articleId;

    @Lob
    @Column(name = "content")
    private Blob content;

    @JoinColumn(name="articles")
    @ManyToOne
    private Articles article;
}
