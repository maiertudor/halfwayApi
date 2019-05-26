package com.ubb935.halfway.service.impl;

import com.ubb935.halfway.converter.AccountConverter;
import com.ubb935.halfway.dto.AccountDto;
import com.ubb935.halfway.model.Account;
import com.ubb935.halfway.repository.AccountRepository;
import com.ubb935.halfway.service.AccountService;
import com.ubb935.halfway.service.exception.ValidationException;
import com.ubb935.halfway.util.enumeration.ValidationCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountConverter accountConverter;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(final AccountRepository accountRepository,
                              final AccountConverter accountConverter,
                              final BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.accountRepository = accountRepository;
        this.accountConverter = accountConverter;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void createAccount(final AccountDto accountDto) throws ValidationException {
        if (this.accountRepository.findByUsername(accountDto.getUsername()) != null) {
            throw new ValidationException(ValidationCode.CODE101.getMessage());
        }
        final Account account = this.accountConverter.convertDtoToModel(accountDto);
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        accountRepository.save(account);
    }
}
