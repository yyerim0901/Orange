package com.project.orange.entity.article;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor//(access = AccessLevel.PROTECTED)
@Data
@AllArgsConstructor
@Entity
@Table(name = "images")
public class ArticleImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;

    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "image_path")
    private String imagePath;

    @JoinColumn(name="articles")
    @ManyToOne
    private Articles article;
}
