package com.profemzy.profilews.api.profile.service;

import com.profemzy.profilews.api.profile.shared.ProfileDto;

public interface ProfileService {
    ProfileDto getProfile(String userId);
    ProfileDto createProfile(ProfileDto profile, String userId);
}
