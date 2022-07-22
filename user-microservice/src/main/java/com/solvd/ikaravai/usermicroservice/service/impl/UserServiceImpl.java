package com.solvd.ikaravai.usermicroservice.service.impl;

import com.solvd.ikaravai.usermicroservice.domain.User;
import com.solvd.ikaravai.usermicroservice.dto.UserWithoutPasswordDto;
import com.solvd.ikaravai.usermicroservice.exceptions.UserNotFoundException;
import com.solvd.ikaravai.usermicroservice.repository.RoleRepository;
import com.solvd.ikaravai.usermicroservice.repository.UserRepository;
import com.solvd.ikaravai.usermicroservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    @Override
    public User save(UserWithoutPasswordDto userWithoutPasswordDto, String rawPassword) {
        User newUser = User.builder()
                .username(userWithoutPasswordDto.getUsername())
                .password(encoder.encode(rawPassword))
                .role("user")
                .build();
        log.info("SAVING OMEGA USER : {}", newUser);
        return userRepository.save(newUser);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            if (!encoder.matches(password, user.getPassword())) throw new UserNotFoundException("Password doesnt match");
        } else throw new UserNotFoundException("No such user");
        return user;
    }
}
