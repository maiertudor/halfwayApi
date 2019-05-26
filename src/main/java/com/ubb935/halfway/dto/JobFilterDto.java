package com.ubb935.halfway.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
@Builder
public class JobFilterDto extends BaseDto {
    private String title;
    private String category;
    private String location;
    private String orderBy;
}