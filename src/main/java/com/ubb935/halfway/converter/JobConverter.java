package com.ubb935.halfway.converter;

import com.ubb935.halfway.dto.JobDto;
import com.ubb935.halfway.model.Job;
import org.springframework.stereotype.Component;

/**
 * Created by Laura on 10/31/2017.
 */
@Component
public class JobConverter extends BaseConverter<Job, JobDto> {

    @Override
    public JobDto convertModelToDto(final Job job) {
         final JobDto jobDto = JobDto.builder()
                .title(job.getTitle())
                .description(job.getDescription())
                .createdAt(job.getCreatedAt().toString())
                .updatedAt(job.getUpdatedAt().toString())
                .endsAt(job.getEndsAt().toString())
                .cost(String.valueOf(job.getCost()))
                .owner(job.getOwner().getUsername())
                .category(job.getCategory().getName())
                .location(job.getLocation().getName())
                .build();
         jobDto.setId(job.getId());
         return jobDto;
    }

    @Override
    public Job convertDtoToModel(final JobDto model) {
        return null;
    }
}
