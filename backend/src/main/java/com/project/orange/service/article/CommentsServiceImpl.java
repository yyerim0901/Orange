package com.project.orange.service.article;

import com.project.orange.entity.article.Comments;
import com.project.orange.repository.article.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentsServiceImpl implements CommentsService{

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public Optional<Comments> selectOne(Long comment) { return commentsRepository.findById(comment); }

    @Override
    public List<Comments> selectAll() { return commentsRepository.findAll(); }

    @Override
    public  Optional<Comments> selectByArticle(Long articleId) { return commentsRepository.findById(articleId); }
}
