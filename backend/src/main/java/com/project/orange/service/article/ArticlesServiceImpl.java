package com.project.orange.service.article;

import com.project.orange.entity.article.Articles;
import com.project.orange.repository.article.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticlesServiceImpl implements ArticlesService{

    @Autowired
    private ArticlesRepository articlesRepository;

    @Override
    public Optional<Articles> selectOne(Long articleId) { return articlesRepository.findById(articleId); }

    @Override
    public List<Articles> selectAll() { return articlesRepository.findAll(); }

    @Override
    public Optional<Articles> createArticle(Articles article) {
        Articles newArticle = articlesRepository.save(article);

        return Optional.ofNullable(newArticle);
    }
}
