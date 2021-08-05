package com.project.orange.service.article;

import com.project.orange.entity.article.Articles;

import java.util.List;
import java.util.Optional;

public interface ArticlesService {
    public Optional<Articles> selectOne(Long article);
    public List<Articles> selectAll();
}
