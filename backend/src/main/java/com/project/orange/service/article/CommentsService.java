package com.project.orange.service.article;

import com.project.orange.entity.article.Comments;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CommentsService {
    public Optional<Comments> selectOne(Long commentId);
    public List<Comments> selectAllByArticleId(Long articleId);
    public List<Comments> selectAll();
    public Optional<Comments> createComment(Comments comments);
    public Optional<Comments> updateComment(Comments comments);
    public void deleteByCommentId(Long commentId);
}
