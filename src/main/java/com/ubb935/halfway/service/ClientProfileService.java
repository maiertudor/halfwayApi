package com.ubb935.halfway.service;

import com.ubb935.halfway.dto.ClientProfileDto;
import com.ubb935.halfway.service.exception.ValidationException;

/**
 * @author ciprian.mosincat on 11/11/2017.
 */
public interface ClientProfileService {

    ClientProfileDto getProfile(String username) throws ValidationException;

    void createProfile(ClientProfileDto clientProfileDto) throws ValidationException;

    void updateProfile(ClientProfileDto clientProfileDto) throws ValidationException;

}
