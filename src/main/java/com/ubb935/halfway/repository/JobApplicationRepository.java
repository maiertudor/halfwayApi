package com.ubb935.halfway.repository;

import com.ubb935.halfway.model.Account;
import com.ubb935.halfway.model.Job;
import com.ubb935.halfway.model.JobApplication;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Laura on 1/12/2018.
 */
@Repository
public interface JobApplicationRepository extends BaseRepository<JobApplication> {

    List<JobApplication> findApplicationByProvider(Account provider);

    List<JobApplication> findApplicationByJob(Job job);

    JobApplication findOneByJob_IdAndProvider_Username(String jobId, String username);

}
