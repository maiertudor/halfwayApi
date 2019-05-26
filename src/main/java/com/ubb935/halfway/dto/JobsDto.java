package com.ubb935.halfway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Laura on 10/31/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JobsDto {
    List<JobDto> jobs;
}
