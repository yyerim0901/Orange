package com.project.orange.entity.article;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor//(access = AccessLevel.PROTECTED)
@Data
@AllArgsConstructor
@Entity
@Table(name = "article_images")
public class ArticleImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "article_id")
//    private Long articleId;

    @Column(name = "image_path")
    private String imagePath;

    @JoinColumn(name="article_id")
    @ManyToOne
    private Articles article;
}
