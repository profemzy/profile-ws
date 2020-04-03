package com.profemzy.profilews.api.profile.io.controllers;

import com.profemzy.profilews.api.profile.service.ProfileService;
import com.profemzy.profilews.api.profile.shared.ProfileDto;
import com.profemzy.profilews.api.profile.ui.model.CreateProfileRequestModel;
import com.profemzy.profilews.api.profile.ui.model.ProfileResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(value = "/{id}/profile",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
            })
    public ProfileResponseModel userProfile(@PathVariable String id) {
        ProfileDto userProfile = profileService.getProfile(id);
        return new ModelMapper().map(userProfile, ProfileResponseModel.class);
    }

    @PostMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<CreateProfileRequestModel> createUserProfile(@Valid @RequestBody CreateProfileRequestModel userProfile, @PathVariable String id) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        ProfileDto profileDto = modelMapper.map(userProfile, ProfileDto.class);
        profileDto.setUserId(id);
        ProfileDto createdProfile = profileService.createProfile(profileDto, id);

        CreateProfileRequestModel returnValue = modelMapper.map(createdProfile, CreateProfileRequestModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }

}
