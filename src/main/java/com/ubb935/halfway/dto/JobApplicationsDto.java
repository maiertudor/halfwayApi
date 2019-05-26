package com.ubb935.halfway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Laura on 1/12/2018.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JobApplicationsDto {
    List<JobApplicationDto> applications;
}
