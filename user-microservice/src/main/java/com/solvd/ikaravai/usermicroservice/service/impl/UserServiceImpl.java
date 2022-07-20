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
    /*private static Map<String, User> users = new HashMap<>();

    static {
        users.put("1", User.builder().id("1").username("name1").password("pass1").role("user").build());
        users.put("2", User.builder().id("2").username("name2").password("pass2").role("user").build());
        users.put("3", User.builder().id("3").username("name3").password("pass3").role("user").build());
    }*/

    @Override
    public User save(UserWithoutPasswordDto userWithoutPasswordDto, String rawPassword) {
        User newUser = User.builder()
                .username(userWithoutPasswordDto.getUsername())
                .password(encoder.encode(rawPassword))
                /*.password(rawPassword)*/
                .role("user")
                .build();
        /*users.put(newUser.getId(), newUser);*/
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
