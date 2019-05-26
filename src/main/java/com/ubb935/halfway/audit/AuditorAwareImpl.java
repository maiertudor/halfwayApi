package com.ubb935.halfway.audit;

import com.ubb935.halfway.model.Account;
import com.ubb935.halfway.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Laura on 11/1/2017.
 */
public class AuditorAwareImpl implements AuditorAware<Account> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getCurrentAuditor() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        return accountRepository.findByUsername(authentication.getName());
    }
}
