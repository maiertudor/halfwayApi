package com.ubb935.halfway.service.impl;

import com.ubb935.halfway.converter.ClientProfileConverter;
import com.ubb935.halfway.dto.ClientProfileDto;
import com.ubb935.halfway.model.Account;
import com.ubb935.halfway.model.ClientProfile;
import com.ubb935.halfway.repository.AccountRepository;
import com.ubb935.halfway.repository.ClientProfileRepository;
import com.ubb935.halfway.service.ClientProfileService;
import com.ubb935.halfway.service.exception.ValidationException;
import com.ubb935.halfway.util.enumeration.ValidationCode;
import com.ubb935.halfway.validator.ProfileValidator;
import org.springframework.stereotype.Service;

import static com.ubb935.halfway.util.AuthenticationUtils.getLoggedInUser;

/**
 * @author ciprian.mosincat on 11/11/2017.
 */
@Service
public class ClientProfileServiceImpl implements ClientProfileService {

    private final AccountRepository accountRepository;
    private final ClientProfileRepository clientProfileRepository;
    private final ClientProfileConverter clientProfileConverter;
    private final ProfileValidator profileValidator;

    public ClientProfileServiceImpl(final AccountRepository accountRepository,
                                    final ClientProfileRepository clientProfileRepository,
                                    final ClientProfileConverter clientProfileConverter,
                                    final ProfileValidator profileValidator) {
        this.accountRepository = accountRepository;
        this.clientProfileRepository = clientProfileRepository;
        this.clientProfileConverter = clientProfileConverter;
        this.profileValidator = profileValidator;
    }

    @Override
    public ClientProfileDto getProfile(final String username) throws ValidationException {
        final ClientProfile profile = this.clientProfileRepository.getProfileByAccount_Username(username);
        if (profile == null){
            throw new ValidationException(ValidationCode.CODE106.getMessage());
        }
        return this.clientProfileConverter.convertModelToDto(profile);
    }

    @Override
    public void createProfile(final ClientProfileDto clientProfileDto) throws ValidationException {
        final String loggedInUser = getLoggedInUser();
        final Account account = this.accountRepository.findByUsername(loggedInUser);
        this.profileValidator.validate(account, clientProfileDto);
        final ClientProfile profile = this.clientProfileConverter.convertDtoToModel(clientProfileDto);
        profile.setAccount(account);
        this.clientProfileRepository.save(profile);
    }

    @Override
    public void updateProfile(final ClientProfileDto clientProfileDto) throws ValidationException {
        final String loggedInUser = getLoggedInUser();
        ClientProfile currentProfile = this.clientProfileRepository.getProfileByAccount_Username(loggedInUser);
        this.updateProfile(currentProfile, clientProfileDto);
        this.clientProfileRepository.save(currentProfile);
    }

    private void updateProfile(ClientProfile currentProfile, final ClientProfileDto clientProfileDto) throws ValidationException {
        if (currentProfile == null) {
            throw new ValidationException(ValidationCode.CODE103.getMessage());
        }
        currentProfile.setFirstName(clientProfileDto.getFirstName());
        currentProfile.setLastName(clientProfileDto.getLastName());
        currentProfile.setEmail(clientProfileDto.getEmail());
    }

}
