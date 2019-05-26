package com.ubb935.halfway.service.impl;

import com.ubb935.halfway.model.Account;
import com.ubb935.halfway.model.JobApplication;
import com.ubb935.halfway.model.Job;
import com.ubb935.halfway.repository.AccountRepository;
import com.ubb935.halfway.repository.JobApplicationRepository;
import com.ubb935.halfway.repository.JobRepository;
import com.ubb935.halfway.service.JobApplicationService;
import com.ubb935.halfway.service.exception.JobApplicationServiceException;
import com.ubb935.halfway.service.exception.ValidationException;
import com.ubb935.halfway.util.enumeration.UserRole;

import static com.ubb935.halfway.util.AuthenticationUtils.getLoggedInUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Laura on 1/12/2018.
 */
@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProviderProfileServiceImpl providerProfileService;

    @Transactional
    public void createApplication(final String jobId) throws JobApplicationServiceException {
        final Account user = this.getCurrentUser();
        if (!user.getRole().equals(UserRole.PROVIDER))
            throw new JobApplicationServiceException("You must be a provider in order to apply for a job!");
        try {
            providerProfileService.getProfile(user.getUsername());
        } catch (final ValidationException e) {
            throw new JobApplicationServiceException("You must have a profile in order to apply for a job!");
        }
        if (this.jobApplicationRepository.findOneByJob_IdAndProvider_Username(jobId, getLoggedInUser())!=null){
            throw new JobApplicationServiceException("You already applied for this job!");
        }
        final Job job = jobRepository.getOne(jobId);
        final JobApplication jobApplication = JobApplication.builder()
                .job(job)
                .build();
        jobApplicationRepository.save(jobApplication);
    }

    public List<JobApplication> getApplicationsForCurrentUser() throws JobApplicationServiceException {
        final Account user = this.getCurrentUser();
        if (!user.getRole().equals(UserRole.PROVIDER))
            throw new JobApplicationServiceException("You must be a provider in order see your job applications!");
        return this.jobApplicationRepository.findApplicationByProvider(user);
    }

    public List<JobApplication> getApplicationsForJob(final String jobId) throws JobApplicationServiceException {
        final Job job = jobRepository.getOne(jobId);
        final Account user = this.getCurrentUser();
        if (!user.getRole().equals(UserRole.CLIENT) || !user.equals(job.getOwner()))
            throw new JobApplicationServiceException("You must be a client and the owner of the job in order see the job applications!");
        return this.jobApplicationRepository.findApplicationByJob(job);
    }

    private Account getCurrentUser() {
        return accountRepository.findByUsername(getLoggedInUser());
    }
}
