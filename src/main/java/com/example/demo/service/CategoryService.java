package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.List;

public interface CategoryService {

    void saveCategory(Category category);

    List<Category> findAllCategory();
}
