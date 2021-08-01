package com.project.orange.entity;

import lombok.*;

import javax.persistence.*;
import java.awt.image.ImageProducer;
import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long commentId;
    @Column(name = "comment_content")
    private String commentContent;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "comment_writetime")
    private Date commentWritetime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Long articleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentWritetime() {
        return commentWritetime;
    }

    public void setCommentWritetime(Date commentWritetime) {
        this.commentWritetime = commentWritetime;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    //    @Builder
//    public Comments(Long commentId, Long articleId, Long userId, String commentContent, Timestamp commentWritetime) {
//        this.commentId = commentId;
//        this.articleId = articleId;
//        this.userId = userId;
//        this.commentContent = commentContent;
//        this.commentWritetime = commentWritetime;
//    }
}
