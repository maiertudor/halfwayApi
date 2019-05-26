package com.ubb935.halfway.controller;

import com.ubb935.halfway.converter.JobApplicationConverter;
import com.ubb935.halfway.dto.JobApplicationsDto;
import com.ubb935.halfway.model.JobApplication;
import com.ubb935.halfway.service.JobApplicationService;
import com.ubb935.halfway.service.exception.JobApplicationServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Laura on 1/12/2018.
 */
@RestController
@RequestMapping("/api/v1")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @Autowired
    private JobApplicationConverter jobApplicationConverter;

    @RequestMapping(value = "/apply/job/{jobId}", method = RequestMethod.POST)
    public ResponseEntity createApplication(@PathVariable final String jobId) {
        ResponseEntity<String> response;
        try {
            jobApplicationService.createApplication(jobId);
            response = new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (final JobApplicationServiceException e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @RequestMapping(value = "/applications/user", method = RequestMethod.GET)
    public JobApplicationsDto getApplicationsForCurrentUser() {
        try {
            final List<JobApplication> jobApplications = jobApplicationService.getApplicationsForCurrentUser();
            return new JobApplicationsDto(jobApplicationConverter.convertModelsToDtos(jobApplications));
        } catch(final JobApplicationServiceException e) {
            //TODO handle this better
            return new JobApplicationsDto();
        }
    }

    @RequestMapping(value = "/applications/job/{jobId}", method = RequestMethod.GET)
    public JobApplicationsDto getApplicationsForJob(@PathVariable final String jobId) {
        try {
            final List<JobApplication> jobApplications = jobApplicationService.getApplicationsForJob(jobId);
            return new JobApplicationsDto(jobApplicationConverter.convertModelsToDtos(jobApplications));
        } catch(final JobApplicationServiceException e) {
            //TODO handle this better
            return new JobApplicationsDto();
        }
    }
}
