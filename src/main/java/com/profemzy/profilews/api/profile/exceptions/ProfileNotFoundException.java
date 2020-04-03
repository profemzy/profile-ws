package com.profemzy.profilews.api.profile.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Profile Not Found")
public class ProfileNotFoundException extends RuntimeException {
}
