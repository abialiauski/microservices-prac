package com.solvd.ikaravai.usermicroservice.service;

import com.solvd.ikaravai.usermicroservice.domain.User;
import com.solvd.ikaravai.usermicroservice.dto.UserWithoutPasswordDto;

import java.util.Optional;

public interface UserService {

    User save(UserWithoutPasswordDto userWithoutPasswordDto, String rawPassword);

    User     findByUsernameAndPassword(String username, String password);
}
