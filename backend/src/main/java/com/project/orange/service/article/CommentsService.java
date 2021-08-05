package com.project.orange.service.article;

import com.project.orange.entity.article.Comments;

import java.util.List;
import java.util.Optional;

public interface CommentsService {
    public Optional<Comments> selectOne(Long comment);
    public Optional<Comments> selectByArticle(Long articleId);
    public List<Comments> selectAll();
}
