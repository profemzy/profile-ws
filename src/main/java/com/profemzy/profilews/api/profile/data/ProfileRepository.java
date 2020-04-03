package com.profemzy.profilews.api.profile.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<ProfileEntity, Long> {
    ProfileEntity findByUserId(String userId);
}
