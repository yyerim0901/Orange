package com.project.orange.service.article;

import com.project.orange.entity.article.Comments;
import com.project.orange.repository.article.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentsServiceImpl implements CommentsService{

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public Optional<Comments> createComment(Comments comments) {
        Comments newComment = commentsRepository.save(comments);

        return Optional.ofNullable(newComment);
    }

    @Override
    public List<Comments> selectAll() { return commentsRepository.findAll(); }

    @Override
    public  List<Comments> selectAllByArticleId(Long article) {
        return commentsRepository.findAllByArticle(article);
    }

    @Override
    public void deleteByCommentId(Long commentId) { commentsRepository.deleteById(commentId); }
}
