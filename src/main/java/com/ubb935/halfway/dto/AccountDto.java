package com.ubb935.halfway.dto;

import com.ubb935.halfway.util.enumeration.UserRole;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import static com.ubb935.halfway.util.ValidationPattern.*;

/**
 * @author ciprian.mosincat on 11/11/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class AccountDto extends BaseDto {

    @NotBlank
    @Length(min = USERNAME_MIN_LENGTH, max = USERNAME_MAX_LENGTH)
    private String username;

    @Length(min = PASSWORD_MIN_LENGTH)
    private String password;

    @Builder.Default
    private UserRole role = UserRole.CLIENT;

}
