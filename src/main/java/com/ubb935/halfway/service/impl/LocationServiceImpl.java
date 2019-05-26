package com.ubb935.halfway.service.impl;

import com.ubb935.halfway.model.Location;
import com.ubb935.halfway.repository.LocationRepository;
import com.ubb935.halfway.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Laura on 10/31/2017.
 */
@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationRepository locationRepository;

    public Location getLocation(final String name) {
        return locationRepository.findByName(name);
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
