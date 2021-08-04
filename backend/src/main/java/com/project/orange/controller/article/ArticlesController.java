package com.project.orange.controller.article;

import com.project.orange.entity.article.Articles;
import com.project.orange.service.article.ArticlesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/article")
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
}
