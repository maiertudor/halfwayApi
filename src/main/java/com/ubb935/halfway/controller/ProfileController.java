package com.ubb935.halfway.controller;

import com.ubb935.halfway.dto.ClientProfileDto;
import com.ubb935.halfway.dto.ProviderProfileDto;
import com.ubb935.halfway.model.enumerations.Ability;
import com.ubb935.halfway.service.ClientProfileService;
import com.ubb935.halfway.service.ProviderProfileService;
import com.ubb935.halfway.service.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.ubb935.halfway.util.AuthenticationUtils.getLoggedInUser;

/**
 * @author ciprian.mosincat on 11/11/2017.
 */
@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    private final ClientProfileService clientProfileService;
    private final ProviderProfileService providerProfileService;

    public ProfileController(final ClientProfileService clientProfileService, final ProviderProfileService providerProfileService) {
        this.clientProfileService = clientProfileService;
        this.providerProfileService = providerProfileService;
    }

    @GetMapping("/client")
    public ClientProfileDto getClientProfile() throws ValidationException {
        return this.clientProfileService.getProfile(getLoggedInUser());
    }

    @GetMapping("/provider")
    public ProviderProfileDto getProviderProfile() throws ValidationException {
        return this.providerProfileService.getProfile(getLoggedInUser());
    }

    @PostMapping("/create/client")
    @ResponseStatus(HttpStatus.OK)
    public void createClientProfile(@RequestBody @Valid final ClientProfileDto clientProfileDto) throws ValidationException {
        this.clientProfileService.createProfile(clientProfileDto);
    }

    @PostMapping("/create/provider")
    @ResponseStatus(HttpStatus.OK)
    public void createProviderProfile(@RequestBody @Valid final ProviderProfileDto providerProfileDto) throws ValidationException {
        this.providerProfileService.createProfile(providerProfileDto);
    }


    @PostMapping("/update/client")
    public void updateClientProfile(@RequestBody @Valid final ClientProfileDto clientProfileDto) throws ValidationException {
        this.clientProfileService.updateProfile(clientProfileDto);
    }

    @PostMapping("/update/provider")
    public void updateProviderProfile(@RequestBody @Valid final ProviderProfileDto providerProfileDto) throws ValidationException {
        this.providerProfileService.updateProfile(providerProfileDto);
    }

    @GetMapping("/abilities")
    public List<String> getAbility() {
        List<Ability> abilities = Arrays.asList(Ability.values());

        return abilities.stream()
                .map(Ability::getValue)
                .collect(Collectors.toList());
    }

}
