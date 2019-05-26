package com.ubb935.halfway.service;

import com.ubb935.halfway.dto.ProviderProfileDto;
import com.ubb935.halfway.service.exception.ValidationException;

/**
 * @author ciprian.mosincat on 11/12/2017.
 */
public interface ProviderProfileService {

    ProviderProfileDto getProfile(String username) throws ValidationException;

    void createProfile(ProviderProfileDto clientProfileDto) throws ValidationException;

    void updateProfile(ProviderProfileDto clientProfileDto) throws ValidationException;

}
