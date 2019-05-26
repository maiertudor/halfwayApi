package com.ubb935.halfway.dto;

import lombok.*;

/**
 * Created by Laura on 10/31/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
@Builder
public class JobDto extends BaseDto {
    private String title;
    private String description;
    private String createdAt;
    private String updatedAt;
    private String endsAt;
    private String cost;
    private String owner;
    private String category;
    private String location;
}
