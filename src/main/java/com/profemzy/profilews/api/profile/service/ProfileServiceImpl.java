package com.profemzy.profilews.api.profile.service;

import com.profemzy.profilews.api.profile.data.ProfileEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Override
    public ProfileEntity getProfile(String userId) {

        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setUserId(userId);
        profileEntity.setProfileId("NHIS101");
        profileEntity.setAddress("No 3 Badmus Street, Ologuneru, Ibadan");
        profileEntity.setPhone("08033574778");
        return profileEntity;
    }
}
