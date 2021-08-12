package com.project.orange.service.article;

import com.project.orange.entity.article.Articles;
import com.project.orange.entity.badge.Badges;
import com.project.orange.entity.challenge.Challenges;
import com.project.orange.entity.user.BadgesUsers;
import com.project.orange.repository.article.ArticlesRepository;
import com.project.orange.repository.badge.BadgeRepository;
import com.project.orange.repository.challenge.ChallengesRepository;
import com.project.orange.repository.user.BadgesUsersRepository;
import com.project.orange.service.badge.BadgesService;
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

    @Override
    public Optional<Articles> selectOne(Long articleId) { return articlesRepository.findById(articleId); }

    @Override
    public List<Articles> selectAll() { return articlesRepository.findAll(); }

//    @Autowired
//    private ArticlesService articlesService;

    @Autowired
    private BadgesService badgesService;

    @Autowired
    public BadgesUsersRepository badgesUsersRepository;


    @Override
    public Optional<Articles> createArticle(Articles article) {
        // 처음 피드 작성시 9번 뱃지 부여 로직
        List<BadgesUsers> badgesUsers;
        badgesUsers = badgesUsersRepository.findByUserAndBadge(article.getUser(), 9L);

        // 처음 얻는 뱃지
        if(badgesUsers.isEmpty()) {
            Long badgeId = 9L;
            Long userId = article.getUser();

            BadgesUsers badgeUser = BadgesUsers.builder()
                    .badge(badgeId)
                    .user(userId)
                    .build();
            badgesUsersRepository.save(badgeUser);
        }

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

//    @Override
//    public List<Articles> selectAllByUserId(Long user) {
//        return articlesRepository.findAllByUser(user);
//    }

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
