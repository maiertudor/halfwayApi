package com.ubb935.halfway.repository;

import com.ubb935.halfway.model.Location;
import org.springframework.stereotype.Repository;

/**
 * Created by Laura on 10/31/2017.
 */
@Repository
public interface LocationRepository extends BaseRepository<Location> {
    Location findByName(String name);
}
