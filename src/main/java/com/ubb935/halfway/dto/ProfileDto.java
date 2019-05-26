package com.ubb935.halfway.dto;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

import static com.ubb935.halfway.util.ValidationPattern.EMAIL_PATTERN;
import static com.ubb935.halfway.util.ValidationPattern.NAME_PATTERN;

/**
 * @author ciprian.mosincat on 11/1/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class ProfileDto extends BaseDto {

    @NotBlank
    @Pattern(regexp = NAME_PATTERN)
    private String firstName;
    @NotBlank
    @Pattern(regexp = NAME_PATTERN)
    private String lastName;
    @NotBlank
    @Pattern(regexp = EMAIL_PATTERN)
    private String email;

}
