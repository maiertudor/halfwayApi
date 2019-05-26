package com.ubb935.halfway.repository;

import com.ubb935.halfway.model.Category;
import com.ubb935.halfway.model.Job;
import com.ubb935.halfway.model.Location;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Laura on 10/31/2017.
 */
@Repository
public interface JobRepository extends BaseRepository<Job>, JpaSpecificationExecutor<Job> {

    List<Job> findJobByTitleContaining(String query);

    List<Job> findJobByLocation(Location location);

    List<Job> findJobByCategory(Category category);

    List<Job> findAllByOrderByUpdatedAt();

    List<Job> findAllByOrderByCreatedAt();

    List<Job> findAllByOrderByEndsAt();

    List<Job> findAllByOrderByCostAsc();

    List<Job> findAllByOrderByCostDesc();

    List<Job> findAllByOwner_Username(String owner_username);

    Job findOneByIdAndOwner_Username(String id, String owner_username);

}