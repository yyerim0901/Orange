package com.project.orange.service.article;

import com.project.orange.entity.article.Articles;
import com.project.orange.repository.article.ArticlesRepository;
import com.project.orange.service.user.BadgesUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import static com.project.orange.management.Constants.*;

@Service
@Transactional
public class ArticlesServiceImpl implements ArticlesService{

    @Autowired
    private ArticlesRepository articlesRepository;

    @Override
    public Optional<Articles> selectOne(Long articleId) { return articlesRepository.findById(articleId); }

    @Override
    public List<Articles> selectAll() { return articlesRepository.findAll(); }

    @Autowired
    private BadgesUsersService badgesUsersService;


    @Override
    public Optional<Articles> createArticle(Articles article) {
        // 처음 피드 작성시 9번 뱃지 부여 로직
        badgesUsersService.badgeAwardAndNotify(article.getUser(), HereICameBadgeId);

        Articles newArticle = articlesRepository.save(article);

        return Optional.ofNullable(newArticle);
    }

    @Override
    public Optional<Articles> updateArticle(Articles article) {
        Articles updatedArticle = articlesRepository.save(article);

        return Optional.ofNullable(updatedArticle);
    }

    @Override
    public List<Articles> selectAllByChallengeId(Long challenge) {
        return articlesRepository.findAllByChallenge(challenge);
    }


    @Override
    public void deleteByArticleId(Long articleId) { articlesRepository.deleteById(articleId); }

}
