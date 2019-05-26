package com.ubb935.halfway.converter;

import com.ubb935.halfway.dto.LocationDto;
import com.ubb935.halfway.model.Location;
import org.springframework.stereotype.Component;

/**
 * Created by Laura on 10/31/2017.
 */
@Component
public class LocationConverter extends BaseConverter<Location, LocationDto> {

    @Override
    public LocationDto convertModelToDto(final Location location) {
        return LocationDto.builder()
                .name(location.getName())
                .build();
    }

    @Override
    public Location convertDtoToModel(final LocationDto model) {
        return null;
    }
}
