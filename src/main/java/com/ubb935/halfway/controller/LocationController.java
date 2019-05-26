package com.ubb935.halfway.controller;

import com.ubb935.halfway.converter.LocationConverter;
import com.ubb935.halfway.dto.LocationsDto;
import com.ubb935.halfway.model.Location;
import com.ubb935.halfway.service.LocationService;
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
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationConverter locationConverter;

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public LocationsDto getAllLocations() {
        final List<Location> locations = locationService.getAllLocations();
        return new LocationsDto(locationConverter.convertModelsToDtos(locations));
    }

}
