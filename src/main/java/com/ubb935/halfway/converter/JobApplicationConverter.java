package com.ubb935.halfway.converter;

import com.ubb935.halfway.dto.JobApplicationDto;
import com.ubb935.halfway.model.JobApplication;
import com.ubb935.halfway.service.ProviderProfileService;
import com.ubb935.halfway.service.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Laura on 1/12/2018.
 */
@Component
public class JobApplicationConverter extends BaseConverter<JobApplication, JobApplicationDto>  {

    @Autowired
    private ProviderProfileService providerProfileService;

    @Autowired
    private JobConverter jobConverter;

    @Override
    public JobApplicationDto convertModelToDto(final JobApplication jobApplication) {
        final JobApplicationDto jobApplicationDto;
        try {
            jobApplicationDto = JobApplicationDto.builder()
                    .provider(providerProfileService.getProfile(jobApplication.getProvider().getUsername()))
                    .job(jobConverter.convertModelToDto(jobApplication.getJob()))
                    .createdAt(jobApplication.getCreatedAt().toString())
                    .build();
        } catch (ValidationException e) {
            throw new RuntimeException("There is no profile!");
        }
        jobApplicationDto.setId(jobApplication.getId());
        return jobApplicationDto;
    }

    @Override
    public JobApplication convertDtoToModel(final JobApplicationDto model) {
        return null;
    }
}
