package com.profemzy.profilews.api.profile.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Profile Already Exist")
public class ProfileAlreadyExistException extends RuntimeException {
}
