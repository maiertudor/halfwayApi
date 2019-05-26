package com.ubb935.halfway.controller;

import com.ubb935.halfway.converter.JobConverter;
import com.ubb935.halfway.dto.JobDto;
import com.ubb935.halfway.dto.JobFilterDto;
import com.ubb935.halfway.dto.JobsDto;
import com.ubb935.halfway.model.Category;
import com.ubb935.halfway.model.Job;
import com.ubb935.halfway.model.Location;
import com.ubb935.halfway.service.CategoryService;
import com.ubb935.halfway.service.JobService;
import com.ubb935.halfway.service.LocationService;
import com.ubb935.halfway.service.exception.JobServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Laura on 10/31/2017.
 */
@RestController
@RequestMapping("/api/v1")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private JobConverter jobConverter;

    @Autowired
    private LocationService locationService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/jobs/user")
    public JobsDto getJobsForUser() {
        final List<Job> jobs = jobService.getAllJobsForLoggedInUser();
        return new JobsDto(jobConverter.convertModelsToDtos(jobs));
    }

    @RequestMapping(value = "/jobs", method = RequestMethod.GET)
    public JobsDto getAllJobs() {
        final List<Job> jobs = jobService.getAllJobs();
        return new JobsDto(jobConverter.convertModelsToDtos(jobs));
    }

    @RequestMapping(value = "/jobs", method = RequestMethod.POST)
    public ResponseEntity createJob(@RequestBody final Map<String, JobDto> jobDtoMap) {
        final JobDto jobDto = jobDtoMap.get("job");
        ResponseEntity<String> response;
        try {
            jobService.createJob(jobDto.getTitle(), jobDto.getDescription(), jobDto.getEndsAt(), jobDto.getCost(), jobDto.getCategory(), jobDto.getLocation());
            response = new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (final JobServiceException e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @RequestMapping(value = "/jobs/filter", method = RequestMethod.POST)
    public JobsDto multiFilterJobs(@RequestBody final JobFilterDto filterDto) {
        final List<Job> jobs = jobService.filterJobs(filterDto.getTitle(), filterDto.getCategory(), filterDto.getLocation(), filterDto.getOrderBy());
        return new JobsDto((jobConverter.convertModelsToDtos(jobs)));
    }

    @RequestMapping(value = "jobs/search/{query}", method = RequestMethod.GET)
    public JobsDto filterJobs(@PathVariable final String query) {
        final List<Job> jobs = jobService.filterJobs(query);
        return new JobsDto((jobConverter.convertModelsToDtos(jobs)));
    }

    @RequestMapping(value = "jobs/location/{location}", method = RequestMethod.GET)
    public JobsDto getJobsByLocation(@PathVariable final String location) {
        final Location l = locationService.getLocation(location);
        final List<Job> jobs = jobService.filterByLocation(l);
        return new JobsDto(jobConverter.convertModelsToDtos(jobs));
    }

    @RequestMapping(value = "jobs/category/{category}", method = RequestMethod.GET)
    public JobsDto getJobsByCategory(@PathVariable final String category) {
        final Category c = categoryService.getCategory(category);
        final List<Job> jobs = jobService.filterByCategory(c);
        return new JobsDto(jobConverter.convertModelsToDtos(jobs));
    }

    @RequestMapping(value = "jobs/created", method = RequestMethod.GET)
    public JobsDto getJobsByCreationDate() {
        final List<Job> jobs = jobService.orderByCreationDate();
        return new JobsDto(jobConverter.convertModelsToDtos(jobs));
    }

    @RequestMapping(value = "jobs/updated", method = RequestMethod.GET)
    public JobsDto getJobsByUpdatedDate() {
        final List<Job> jobs = jobService.orderByUpdatedDate();
        return new JobsDto(jobConverter.convertModelsToDtos(jobs));
    }

    @RequestMapping(value = "jobs/ended", method = RequestMethod.GET)
    public JobsDto getJobsByEndingDate() {
        final List<Job> jobs = jobService.orderByEndingDate();
        return new JobsDto(jobConverter.convertModelsToDtos(jobs));
    }

    @RequestMapping(value = "jobs/cost/asc", method = RequestMethod.GET)
    public JobsDto getJobsByCostAsc() {
        final List<Job> jobs = jobService.orderByCostAsc();
        return new JobsDto(jobConverter.convertModelsToDtos(jobs));
    }

    @RequestMapping(value = "jobs/cost/desc", method = RequestMethod.GET)
    public JobsDto getJobsByCostDesc() {
        final List<Job> jobs = jobService.orderByCostDesc();
        return new JobsDto(jobConverter.convertModelsToDtos(jobs));
    }

    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateJob(
            @PathVariable final String id,
            @RequestBody final Map<String, JobDto> jobDtoMap) {
        final JobDto jobDto = jobDtoMap.get("job");
        ResponseEntity<String> response;
        try {
            jobService.updateJob(id, jobDto.getTitle(), jobDto.getDescription(), jobDto.getEndsAt(), jobDto.getCost(), jobDto.getCategory(), jobDto.getLocation());
            response = new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (final JobServiceException e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteJob(@PathVariable final String id) {
        ResponseEntity<String> response;
        try {
            jobService.deleteJob(id);
            response = new ResponseEntity<>("success", HttpStatus.OK);
        } catch (final JobServiceException e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
