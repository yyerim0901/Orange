package com.project.orange.controller.challenge;

import com.project.orange.entity.challenge.Categories;
import com.project.orange.service.challenge.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/category/list")
    public ResponseEntity<List<Categories>> selectAll(){
        List<Categories> list = categoryService.selectAll();
        if(list != null && !list.isEmpty()) {
            return new ResponseEntity<List<Categories>>(list, HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
