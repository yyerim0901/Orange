package com.project.orange.controller.article;

import com.project.orange.entity.article.Comments;
import com.project.orange.service.article.CommentsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/comment")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @ApiOperation(value = "모든 댓글 목록", notes = "<big>모든 댓글</big>의 <big>목록</big> 반환")
    @GetMapping("/list")
    public ResponseEntity<List<Comments>> selectAll(){
        List<Comments> list = commentsService.selectAll();
        if(list != null && !list.isEmpty()) {
            return new ResponseEntity<List<Comments>>(list, HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
