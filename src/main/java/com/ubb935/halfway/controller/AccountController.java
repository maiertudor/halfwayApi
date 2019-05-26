package com.ubb935.halfway.controller;

import com.ubb935.halfway.dto.AccountDto;
import com.ubb935.halfway.service.AccountService;
import com.ubb935.halfway.service.exception.ValidationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    private final AccountService accountService;

    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody @Valid final AccountDto accountDto) throws ValidationException {
        accountService.createAccount(accountDto);
    }

}

