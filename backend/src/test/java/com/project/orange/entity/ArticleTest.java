package com.project.orange.entity;

import com.project.orange.entity.article.Articles;
import com.project.orange.entity.challenge.Challenges;
import com.project.orange.service.article.ArticlesService;
import com.project.orange.service.challenge.ChallengeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ArticleTest {

    @Autowired
    private ArticlesService articlesService;

    @Test
    void createNewArticleTest(){
        Long challengeId = 30L;
//        Optional<Challenges> challenge = ChallengeService.selectByChallengeId(challengeId);
        Long userId = 17L;
        String title = "제목";
        String articleContent = "내용";
        LocalDateTime now = LocalDateTime.now();
        Boolean verified = Boolean.TRUE;

        Articles article = Articles.builder()
                .title(title)
                .articleContent(articleContent)
                .articleWritetime(now)
                .verified(verified)
                .challenge(challengeId)
//                .challenge(challenge)
                .user(userId)
                .build();

        Optional<Articles> createdArticle = articlesService.createArticle(article);
        assertEquals(createdArticle.isEmpty(), false);


    }
}
