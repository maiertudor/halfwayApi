package com.ubb935.halfway.repository;

import com.ubb935.halfway.model.ProviderProfile;
import org.springframework.stereotype.Repository;

/**
 * @author ciprian.mosincat on 11/12/2017.
 */
@Repository
public interface ProviderProfileRepository extends BaseRepository<ProviderProfile>{

    ProviderProfile getProfileByAccount_Username(String username);

}
