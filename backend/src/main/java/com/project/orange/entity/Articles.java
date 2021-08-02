package com.project.orange.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Setter
@Entity
@Table(name = "articles")
public class Articles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long articleId;

//    피드에서 이미지와 댓글에 접근
    @OneToMany(mappedBy = "images")
    private List<Images> articleImages = new ArrayList<>();

    @OneToMany(mappedBy = "comments")
    private List<Comments> articleComments = new ArrayList<>();

//    피드에서 챌린지와 유저에 접근
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id")
    private Challenges challengeTd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userTd;

    @Column(name = "title")
    private String title;

    @Column(name = "article_content")
    private String articleContent;

    @Temporal(TemporalType.DATE)
    @Column(name = "article_writetime")
    private Date articleWritetime;

    @Column(name = "verified")
    private Boolean verified;


}