package com.project.orange.service.article;

import com.project.orange.entity.article.ArticleImages;
import com.project.orange.repository.article.ArticleImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleImagesServiceImpl implements ArticleImagesService{

    @Autowired
    private ArticleImagesRepository articleImagesRepository;

    @Override
    public Optional<ArticleImages> selectOne(Long imageId) {return articleImagesRepository.findById(imageId); }

    @Override
    public List<ArticleImages> selectAll() { return articleImagesRepository.findAll(); }

    @Override
    public List<ArticleImages> saveAll(List<ArticleImages> articleImagesList) {
        return articleImagesRepository.saveAll(articleImagesList);
    }
}
