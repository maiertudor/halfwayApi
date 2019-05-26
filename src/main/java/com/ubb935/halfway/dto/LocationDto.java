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
public class LocationDto extends BaseDto {
    private String name;
}
