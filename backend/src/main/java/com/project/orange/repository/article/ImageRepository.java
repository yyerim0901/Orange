package com.project.orange.repository.article;

import com.project.orange.entity.article.ArticleImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ArticleImages, Long> {
}
