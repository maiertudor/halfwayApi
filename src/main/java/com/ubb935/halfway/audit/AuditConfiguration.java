package com.ubb935.halfway.audit;

import com.ubb935.halfway.model.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by Laura on 11/1/2017.
 */
@Configuration
@EnableJpaAuditing
public class AuditConfiguration {

    @Bean
    public AuditorAware<Account> auditorProvider() {
        return new AuditorAwareImpl();
    }
}
