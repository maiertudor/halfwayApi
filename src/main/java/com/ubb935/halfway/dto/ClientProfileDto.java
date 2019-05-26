package com.ubb935.halfway.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author ciprian.mosincat on 11/11/2017.
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ClientProfileDto extends ProfileDto {

    private static final long serialVersionUID = -1695879626216862279L;

    @Builder
    public ClientProfileDto(final String firstName, final String lastName, final String email) {
        super(firstName, lastName, email);
    }

}