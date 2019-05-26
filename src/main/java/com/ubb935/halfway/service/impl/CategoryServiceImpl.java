package com.ubb935.halfway.service.impl;

import com.ubb935.halfway.model.Category;
import com.ubb935.halfway.repository.CategoryRepository;
import com.ubb935.halfway.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Laura on 10/31/2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category getCategory(final String name) {
        return categoryRepository.findByName(name);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
