package com.ubb935.halfway.service.impl;

import com.ubb935.halfway.model.Category;
import com.ubb935.halfway.model.Job;
import com.ubb935.halfway.model.Location;
import com.ubb935.halfway.repository.CategoryRepository;
import com.ubb935.halfway.repository.JobRepository;
import com.ubb935.halfway.repository.LocationRepository;
import com.ubb935.halfway.service.JobService;
import com.ubb935.halfway.service.exception.JobServiceException;
import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.ubb935.halfway.util.AuthenticationUtils.getLoggedInUser;

/**
 * Created by Laura on 10/31/2017.
 */
@Service
public class JobServiceImpl implements JobService {

    private final Validator validator = Validation
            .byProvider(HibernateValidator.class)
            .configure()
            .buildValidatorFactory()
            .getValidator();
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private LocationRepository locationRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public List<Job> filterJobs(final String query) {
        return jobRepository.findJobByTitleContaining(query);
    }

    @Override
    public List<Job> getAllJobsForLoggedInUser() {
        return this.jobRepository.findAllByOwner_Username(getLoggedInUser());
    }

    @Override
    public List<Job> filterJobs(String title, String category, String location, String orderBy) {
        return jobRepository.findAll().stream().filter(job ->
                (title == null || job.getTitle().contains(title))
                        && (job.getCategory().getName().equalsIgnoreCase(category) || category == null)
                        && (job.getLocation().getName().equalsIgnoreCase(location) || location == null)
        ).sorted((a, b) -> {
            if (Objects.equals(orderBy, "cost_asc")) return a.getCost().compareTo(b.getCost());
            if (Objects.equals(orderBy, "cost_desc")) return b.getCost().compareTo(a.getCost());
            if (Objects.equals(orderBy, "creation_date")) return a.getCreatedAt().compareTo(b.getCreatedAt());
            if (Objects.equals(orderBy, "updated_date")) return a.getUpdatedAt().compareTo(b.getUpdatedAt());
            if (Objects.equals(orderBy, "ending_date")) return a.getEndsAt().compareTo(b.getEndsAt());
            return a.getUpdatedAt().compareTo(b.getUpdatedAt());
        }).collect(Collectors.toList());
    }

    public List<Job> filterByLocation(final Location location) {
        return jobRepository.findJobByLocation(location);
    }

    public List<Job> filterByCategory(final Category category) {
        return jobRepository.findJobByCategory(category);
    }

    public List<Job> orderByCreationDate() {
        return jobRepository.findAllByOrderByCreatedAt();
    }

    public List<Job> orderByUpdatedDate() {
        return jobRepository.findAllByOrderByUpdatedAt();
    }

    public List<Job> orderByEndingDate() {
        return this.jobRepository.findAllByOrderByEndsAt();
    }

    public List<Job> orderByCostAsc() {
        return this.jobRepository.findAllByOrderByCostAsc();
    }

    public List<Job> orderByCostDesc() {
        return this.jobRepository.findAllByOrderByCostDesc();
    }

    @Transactional
    public void createJob(final String title, final String description, final String ends_at, final String cost, final String category, final String location) throws JobServiceException {
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.S");
        final Date ends_at_date;
        final Integer salary;

        try {
            ends_at_date = format.parse(ends_at);
            salary = Integer.parseInt(cost);
        } catch (final ParseException e) {
            throw new JobServiceException("Invalid date format for the end date!");
        } catch (final NumberFormatException nex) {
            throw new JobServiceException("Invalid cost!");
        }

        final Job job = Job.builder()
                .title(title)
                .description(description)
                .endsAt(ends_at_date)
                .cost(salary)
                .category(categoryRepository.findByName(category))
                .location(locationRepository.findByName(location))
                .build();
        validateJob(job);
        jobRepository.save(job);
    }

    @Transactional
    public void updateJob(final String id, final String title, final String description, final String ends_at, final String cost, final String category, final String location) throws JobServiceException {
        final Job job = jobRepository.findOne(id);
        if (job == null) {
            throw new JobServiceException("There is no job with the given id!");
        }
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.S");
        final Date ends_at_date;
        try {
            ends_at_date = format.parse(ends_at);
        } catch (final ParseException e) {
            throw new JobServiceException("Invalid date format for the end date!");
        }
        job.setTitle(title);
        job.setDescription(description);
        job.setEndsAt(ends_at_date);
        job.setCost(Integer.parseInt(cost));
        job.setCategory(categoryRepository.findByName(category));
        job.setLocation(locationRepository.findByName(location));
        validateJob(job);
    }

    @Transactional
    public void deleteJob(final String id) throws JobServiceException {
        final Job job = this.jobRepository.findOne(id);
        if (job == null) {
            throw new JobServiceException("There is no job with the given id for logged in user!");
        }
        this.jobRepository.delete(job);
    }

    public int countAll(){
        return (int) jobRepository.count();
    }

    private void validateJob(final Job job) throws JobServiceException {
        final Set<ConstraintViolation<Job>> constraintViolations = validator.validate(job);
        if (constraintViolations.size() > 0) {
            final String violations = constraintViolations.stream().map(ConstraintViolation::getMessage).reduce("", (c1, c2) -> c1 + "\n" + c2);
            throw new JobServiceException(violations);
        }
    }

}
