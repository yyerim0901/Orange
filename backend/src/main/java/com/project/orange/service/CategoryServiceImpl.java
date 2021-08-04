package com.project.orange.service;

import com.project.orange.entity.challenge.Categories;
import com.project.orange.repository.challenge.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public Optional<Categories> selectOne(Long categoryId) {
        return categoriesRepository.findById(categoryId);
    }

    @Override
    public List<Categories> selectAll() {
        return categoriesRepository.findAll();
    }
}
