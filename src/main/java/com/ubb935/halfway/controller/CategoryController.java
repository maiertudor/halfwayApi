package com.ubb935.halfway.controller;

import com.ubb935.halfway.converter.CategoryConverter;
import com.ubb935.halfway.dto.CategoriesDto;
import com.ubb935.halfway.model.Category;
import com.ubb935.halfway.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Laura on 10/31/2017.
 */
@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryConverter categoryConverter;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public CategoriesDto getAllCategories() {
        final List<Category> categories = categoryService.getAllCategories();
        return new CategoriesDto(categoryConverter.convertModelsToDtos(categories));
    }

}
