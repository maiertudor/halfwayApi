package com.ubb935.halfway.service;

import com.ubb935.halfway.model.Location;

import java.util.List;

/**
 * Created by Laura on 1/13/2018.
 */
public interface LocationService {
    Location getLocation(String name);
    List<Location> getAllLocations();
}
