package com.ubb935.halfway.service;

import com.ubb935.halfway.model.Category;

import java.util.List;

/**
 * Created by Laura on 1/13/2018.
 */
public interface CategoryService {
    Category getCategory(String name);
    List<Category> getAllCategories();
}
