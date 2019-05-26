package com.ubb935.halfway.converter;

import com.ubb935.halfway.dto.AccountDto;
import com.ubb935.halfway.model.Account;
import org.springframework.stereotype.Component;

/**
 * @author ciprian.mosincat on 11/11/2017.
 */
@Component
public class AccountConverter extends BaseConverter<Account, AccountDto> {
    @Override
    public AccountDto convertModelToDto(final Account account) {
        return null;
    }

    @Override
    public Account convertDtoToModel(final AccountDto model) {
        return new Account(model.getUsername(), model.getPassword(), model.getRole());
    }
}
