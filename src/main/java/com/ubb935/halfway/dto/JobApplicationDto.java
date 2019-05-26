package com.ubb935.halfway.dto;

import lombok.*;

/**
 * Created by Laura on 1/12/2018.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
@Builder
public class JobApplicationDto extends BaseDto {
    private ProviderProfileDto provider;
    private JobDto job;
    private String createdAt;
}
