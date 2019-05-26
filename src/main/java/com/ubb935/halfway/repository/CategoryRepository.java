package com.ubb935.halfway.repository;

import com.ubb935.halfway.model.Category;
import org.springframework.stereotype.Repository;

/**
 * Created by Laura on 10/31/2017.
 */
@Repository
public interface CategoryRepository extends BaseRepository<Category> {
    Category findByName(String name);
}
