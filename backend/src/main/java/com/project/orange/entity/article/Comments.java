package com.project.orange.entity.article;

import com.project.orange.entity.user.Users;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor//(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
@Table(name = "comments")
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
    private Articles article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    //    @Builder
//    public Comments(Long commentId, Long articleId, Long userId, String commentContent, Timestamp commentWritetime) {
//        this.commentId = commentId;
//        this.articleId = articleId;
//        this.userId = userId;
//        this.commentContent = commentContent;
//        this.commentWritetime = commentWritetime;
//    }
}
