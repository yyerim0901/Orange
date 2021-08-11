package com.project.orange.repository.article;

import com.project.orange.entity.article.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
    public List<Comments> findAllByArticle(Long article);
}