package com.ubb935.halfway.validator;

import com.ubb935.halfway.dto.ClientProfileDto;
import com.ubb935.halfway.dto.ProfileDto;
import com.ubb935.halfway.dto.ProviderProfileDto;
import com.ubb935.halfway.model.Account;
import com.ubb935.halfway.repository.ProfileRepository;
import com.ubb935.halfway.service.exception.ValidationException;
import com.ubb935.halfway.util.enumeration.UserRole;
import com.ubb935.halfway.util.enumeration.ValidationCode;
import org.springframework.stereotype.Component;

/**
 * @author ciprian.mosincat on 11/12/2017.
 */
@Component
public class ProfileValidator {

    private final ProfileRepository profileRepository;

    public ProfileValidator(final ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public void validate(final Account account, final ProfileDto profileDto) throws ValidationException {
        if (account == null) {
            throw new ValidationException(ValidationCode.CODE104.getMessage());
        } else if (profileDto instanceof ProviderProfileDto && UserRole.CLIENT.equals(account.getRole())) {
            throw new ValidationException(ValidationCode.CODE105.getMessage());
        } else if (profileDto instanceof ClientProfileDto && UserRole.PROVIDER.equals(account.getRole())) {
            throw new ValidationException(ValidationCode.CODE105.getMessage());
        } else if (this.profileRepository.findByAccount_Username(account.getUsername()) != null) {
            throw new ValidationException(ValidationCode.CODE102.getMessage());
        }
    }

}
