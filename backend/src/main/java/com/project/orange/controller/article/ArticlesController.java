package com.project.orange.controller.article;

import com.project.orange.entity.article.Articles;
import com.project.orange.service.article.ArticlesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/article")
public class ArticlesController {
    @Autowired
    private ArticlesService articlesService;

    @ApiOperation(value = "피드 목록", notes = "<big>모든 피드</big>의 <big>목록</big> 반환")
    @GetMapping("/list")
    public ResponseEntity<List<Articles>> selectAll(){
        List<Articles> list = articlesService.selectAll();
        if(list != null && !list.isEmpty()) {
            return new ResponseEntity<List<Articles>>(list, HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @ApiOperation(value = "생성된 피드", notes = "<big>생성된 피드</big> 반환")
    @PostMapping("/create")
    public ResponseEntity<String> createArticle(@RequestBody Articles article){
        Optional<Articles> createdArticle;
        createdArticle = articlesService.createArticle(article);

        if(createdArticle.isPresent()){
            return new ResponseEntity(createdArticle.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @ApiOperation(value = "피드 목록", notes = "<big>챌린지</big>에 있는 <big>모든 피드</big>의 <big>목록</big> 반환")
    @GetMapping("/challenge/{challengeId}")
    public ResponseEntity<List<Articles>> selectAllByChallengeId(@PathVariable Long challengeId){
        List<Articles> list;
        list = articlesService.selectAllByChallengeId(challengeId);
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{articleId}")
    public ResponseEntity<String> delete(@PathVariable Long articleId){
        try {
            articlesService.deleteByArticleId(articleId);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("failed", HttpStatus.NO_CONTENT);
        }
    }
}
