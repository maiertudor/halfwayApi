package com.ubb935.halfway.service;

import com.ubb935.halfway.dto.AccountDto;
import com.ubb935.halfway.service.exception.ValidationException;

/**
 * @author ciprian.mosincat on 11/11/2017.
 */
public interface AccountService {
    void createAccount(AccountDto accountDto) throws ValidationException;
}
