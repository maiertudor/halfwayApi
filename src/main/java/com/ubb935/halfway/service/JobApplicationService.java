package com.ubb935.halfway.service;

import com.ubb935.halfway.model.JobApplication;
import com.ubb935.halfway.service.exception.JobApplicationServiceException;

import java.util.List;

/**
 * Created by Laura on 1/13/2018.
 */
public interface JobApplicationService {
    void createApplication(String jobId) throws JobApplicationServiceException;
    List<JobApplication> getApplicationsForCurrentUser() throws JobApplicationServiceException;
    List<JobApplication> getApplicationsForJob(String jobId) throws JobApplicationServiceException;
}
