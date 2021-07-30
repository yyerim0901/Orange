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
    private Long userid;
    @Column(name = "comment_content")
    private String commentContent;

    @Temporal(TemporalType.DATE)
    @Column(name = "comment_writetime")
    private Date commentTime;

    @Builder
    public Comments(Long commentId, Long articleId, Long userid, String commentContent, Timestamp commentTime) {
        this.commentId = commentId;
        this.articleId = articleId;
        this.userid = userid;
        this.commentContent = commentContent;
        this.commentTime = commentTime;
    }
}
