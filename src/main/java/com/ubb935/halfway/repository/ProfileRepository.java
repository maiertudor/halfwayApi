package com.ubb935.halfway.repository;

import com.ubb935.halfway.model.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author ciprian.mosincat on 11/12/2017.
 */
@Repository
public interface ProfileRepository extends BaseRepository<Profile> {

    Profile findByAccount_Username(String username);

}
