package com.project.orange.service;

import com.project.orange.entity.challenge.Categories;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public Optional<Categories> selectOne(Long categoryId);
    public List<Categories> selectAll();
}
