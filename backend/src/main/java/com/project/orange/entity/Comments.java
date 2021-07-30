package com.project.orange.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class Comments {

    @Id
    @Column(name = "comment_id")
    private Long commentId;
    @Column(name = "article_id")
    private Long articleId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "comment_content")
    private String commentContent;

    @Temporal(TemporalType.DATE)
    @Column(name = "comment_writetime")
    private Date commentWritetime;

    @Builder
    public Comments(Long commentId, Long articleId, Long userId, String commentContent, Timestamp commentWritetime) {
        this.commentId = commentId;
        this.articleId = articleId;
        this.userId = userId;
        this.commentContent = commentContent;
        this.commentWritetime = commentWritetime;
    }
}
