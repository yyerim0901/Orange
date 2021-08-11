package com.project.orange.service.article;

import com.project.orange.entity.article.Articles;
import com.project.orange.entity.challenge.Challenges;
import com.project.orange.repository.article.ArticlesRepository;
import com.project.orange.repository.challenge.ChallengesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticlesServiceImpl implements ArticlesService{

    @Autowired
    private ArticlesRepository articlesRepository;

    @Autowired
    private ChallengesRepository challengesRepository;

    @Override
    public Optional<Articles> selectOne(Long articleId) { return articlesRepository.findById(articleId); }

    @Override
    public List<Articles> selectAll() { return articlesRepository.findAll(); }


    @Override
    public Optional<Articles> createArticle(Articles article) {
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
//    @Override
//    public List<Articles> selectByChallenge(Articles challenge) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
//        EntityManager em = emf.createEntityManager();
////        EntityTransaction tx = em.getTransaction();
//
//        List<Articles> challengeArticles =
//                em.createQuery("SELECT a FROM Articles as a where a.challenge = :challenge", Articles.class)
//                        .setParameter("challenge", challenge)
//                        .getResultList();
//        return challengeArticles;
//    }
}
