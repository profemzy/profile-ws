package com.profemzy.profilews.api.profile.service;

import com.profemzy.profilews.api.profile.data.ProfileEntity;
import com.profemzy.profilews.api.profile.data.ProfileRepository;
import com.profemzy.profilews.api.profile.exceptions.ProfileAlreadyExistException;
import com.profemzy.profilews.api.profile.exceptions.ProfileNotFoundException;
import com.profemzy.profilews.api.profile.shared.ProfileDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public ProfileDto getProfile(String userId) {
        ProfileEntity profileEntity = profileRepository.findByUserId(userId);
        if (profileEntity == null) throw new ProfileNotFoundException();

        return new ModelMapper().map(profileEntity, ProfileDto.class);
    }

    @Override
    public ProfileDto createProfile(ProfileDto profile, String userId) {

        ProfileEntity existingProfile = profileRepository.findByUserId(userId);
        if(existingProfile != null) throw new ProfileAlreadyExistException();

        profile.setProfileId(UUID.randomUUID().toString());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        ProfileEntity profileEntity = modelMapper.map(profile, ProfileEntity.class);
        profileRepository.save(profileEntity);

        return modelMapper.map(profile, ProfileDto.class);
    }

//    @Override
//    public List<ProfileDto> profiles() {
//        List<ProfileEntity> profileEntities = profileRepository.findAll();
//
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//
//        Type listType = new TypeToken<List<ProfileDto>>() {
//        }.getType();
//        return modelMapper.map(profileEntities, listType);
//    }
}
