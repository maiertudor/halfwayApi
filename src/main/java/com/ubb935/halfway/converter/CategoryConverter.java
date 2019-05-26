package com.ubb935.halfway.converter;

import com.ubb935.halfway.dto.CategoryDto;
import com.ubb935.halfway.model.Category;
import org.springframework.stereotype.Component;

/**
 * Created by Laura on 10/31/2017.
 */
@Component
public class CategoryConverter extends BaseConverter<Category, CategoryDto> {

    @Override
    public CategoryDto convertModelToDto(final Category category) {
        return CategoryDto.builder()
                .name(category.getName())
                .build();
    }

    @Override
    public Category convertDtoToModel(final CategoryDto model) {
        return null;
    }

}
