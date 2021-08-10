package com.project.orange.controller.article;

import com.project.orange.entity.article.Comments;
import com.project.orange.service.article.CommentsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
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

    @PostMapping("/create")
    public ResponseEntity<String> createComment(@RequestBody Comments comments) {
        Optional<Comments> createdComment;
        createdComment = commentsService.createComment(comments);

        if(createdComment.isPresent()){
            return new ResponseEntity(createdComment.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/article/{articleId}")
    public ResponseEntity<List<Comments>> selectAllByArticleId(@PathVariable Long articleId){
        List<Comments> list;
        list = commentsService.selectAllByArticleId(articleId);
        if(list == null || list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{commentId")
    public ResponseEntity<String> delete(@PathVariable Long commentId){
        try {
            commentsService.deleteByCommentId(commentId);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("failed", HttpStatus.NO_CONTENT);
        }
    }
}
