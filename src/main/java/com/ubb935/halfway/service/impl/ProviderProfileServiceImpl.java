package com.ubb935.halfway.service.impl;

import com.ubb935.halfway.converter.ProviderProfileConverter;
import com.ubb935.halfway.dto.ProviderProfileDto;
import com.ubb935.halfway.model.Account;
import com.ubb935.halfway.model.Profile;
import com.ubb935.halfway.model.ProviderProfile;
import com.ubb935.halfway.repository.AccountRepository;
import com.ubb935.halfway.repository.ProfileRepository;
import com.ubb935.halfway.repository.ProviderProfileRepository;
import com.ubb935.halfway.service.ProviderProfileService;
import com.ubb935.halfway.service.exception.ValidationException;
import com.ubb935.halfway.util.enumeration.ValidationCode;
import com.ubb935.halfway.validator.ProfileValidator;
import org.springframework.stereotype.Service;

import static com.ubb935.halfway.util.AuthenticationUtils.getLoggedInUser;

/**
 * @author ciprian.mosincat on 11/12/2017.
 */
@Service
public class ProviderProfileServiceImpl implements ProviderProfileService {

    private final AccountRepository accountRepository;
    private final ProfileValidator profileValidator;
    private final ProviderProfileRepository providerProfileRepository;
    private final ProviderProfileConverter providerProfileConverter;

    public ProviderProfileServiceImpl(final AccountRepository accountRepository,
                                      final ProfileValidator profileValidator,
                                      final ProviderProfileRepository providerProfileRepository,
                                      final ProviderProfileConverter providerProfileConverter) {
        this.accountRepository = accountRepository;
        this.profileValidator = profileValidator;
        this.providerProfileRepository = providerProfileRepository;
        this.providerProfileConverter = providerProfileConverter;
    }

    @Override
    public ProviderProfileDto getProfile(final String username) throws ValidationException {
        final ProviderProfile providerProfile = this.providerProfileRepository.getProfileByAccount_Username(username);
        if (providerProfile == null){
            throw new ValidationException(ValidationCode.CODE106.getMessage());
        }
        return this.providerProfileConverter.convertModelToDto(providerProfile);
    }

    @Override
    public void createProfile(final ProviderProfileDto providerProfileDto) throws ValidationException {
        final String loggedInUser = getLoggedInUser();
        final Account account = this.accountRepository.findByUsername(loggedInUser);
        this.profileValidator.validate(account, providerProfileDto);
        final ProviderProfile profile = this.providerProfileConverter.convertDtoToModel(providerProfileDto);
        profile.setAccount(account);
        this.providerProfileRepository.save(profile);
    }

    @Override
    public void updateProfile(final ProviderProfileDto providerProfileDto) throws ValidationException {
        final String loggedInUser = getLoggedInUser();
        ProviderProfile currentProfile = this.providerProfileRepository.getProfileByAccount_Username(loggedInUser);
        this.updateProfile(currentProfile, providerProfileDto);
        this.providerProfileRepository.save(currentProfile);
    }

    private void updateProfile(ProviderProfile currentProfile, final ProviderProfileDto providerProfileDto) throws ValidationException {
        if (currentProfile == null) {
            throw new ValidationException(ValidationCode.CODE103.getMessage());
        }
        currentProfile.setFirstName(providerProfileDto.getFirstName());
        currentProfile.setLastName(providerProfileDto.getLastName());
        currentProfile.setEmail(providerProfileDto.getEmail());
        currentProfile.setAbilities(providerProfileDto.getAbilities());
    }

}
