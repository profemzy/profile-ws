package com.profemzy.profilews.api.profile.io.controllers;

import com.profemzy.profilews.api.profile.data.ProfileEntity;
import com.profemzy.profilews.api.profile.service.ProfileService;
import com.profemzy.profilews.api.profile.ui.model.ProfileResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/{id}/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
            })
    public ProfileResponseModel userProfile(@PathVariable String id) {
        ProfileEntity userProfile = profileService.getProfile(id);
        return new ModelMapper().map(userProfile, ProfileResponseModel.class);
    }

}
