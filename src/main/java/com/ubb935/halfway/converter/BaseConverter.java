package com.ubb935.halfway.converter;

import com.ubb935.halfway.dto.BaseDto;
import com.ubb935.halfway.model.BaseEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Laura on 10/31/2017.
 */
public abstract class BaseConverter<Model extends BaseEntity, Dto extends BaseDto> {

    public abstract Dto convertModelToDto(Model model);

    public abstract Model convertDtoToModel(Dto model);

    public List<Dto> convertModelsToDtos(final Collection<Model> models) {
        return models.stream()
                .map(this::convertModelToDto)
                .collect(Collectors.toList());
    }

}
