package com.ubb935.halfway.repository;

import com.ubb935.halfway.model.ClientProfile;
import org.springframework.stereotype.Repository;

/**
 * @author ciprian.mosincat on 11/11/2017.
 */
@Repository
public interface ClientProfileRepository extends BaseRepository<ClientProfile> {

    ClientProfile getProfileByAccount_Username(String username);

}
