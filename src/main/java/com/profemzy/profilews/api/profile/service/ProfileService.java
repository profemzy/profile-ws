package com.profemzy.profilews.api.profile.service;

import com.profemzy.profilews.api.profile.data.ProfileEntity;

public interface ProfileService {
    ProfileEntity getProfile(String userId);
}
