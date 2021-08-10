package com.project.orange.service.article;

import com.project.orange.entity.article.Comments;

import java.util.List;
import java.util.Optional;

public interface CommentsService {
    public List<Comments> selectAllByArticleId(Long articleId);
    public List<Comments> selectAll();
    public Optional<Comments> createComment(Comments comments);
    public void deleteByCommentId(Long commentId);
}
