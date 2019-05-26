package com.ubb935.halfway.repository;

import com.ubb935.halfway.model.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by vladplaton on 28/10/2017.
 */
@Repository
public interface AccountRepository extends BaseRepository<Account> {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    Account findByUsername(String username);

    Account findById(String id);
}
