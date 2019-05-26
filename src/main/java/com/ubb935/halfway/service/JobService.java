package com.ubb935.halfway.service;

import com.ubb935.halfway.model.Category;
import com.ubb935.halfway.model.Job;
import com.ubb935.halfway.model.Location;
import com.ubb935.halfway.service.exception.JobServiceException;

import java.util.List;

/**
 * Created by Laura on 1/13/2018.
 */
public interface JobService {
    List<Job> getAllJobs();
    List<Job> filterJobs(String query);

    List<Job> getAllJobsForLoggedInUser();

    List<Job> filterJobs(String title, String category, String location, String orderBy);
    List<Job> filterByLocation(Location location);
    List<Job> filterByCategory(Category category);
    List<Job> orderByCreationDate();
    List<Job> orderByUpdatedDate();
    List<Job> orderByEndingDate();
    List<Job> orderByCostAsc();
    List<Job> orderByCostDesc();
    void createJob(String title, String description, String ends_at, String cost, String category, String location) throws JobServiceException;
    void updateJob(String id, String title, String description, String ends_at, String cost, String category, String location) throws JobServiceException;
    void deleteJob(String id) throws JobServiceException;

    int countAll();
}
