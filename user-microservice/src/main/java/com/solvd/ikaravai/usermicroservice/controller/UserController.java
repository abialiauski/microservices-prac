package com.solvd.ikaravai.usermicroservice.controller;

import com.solvd.ikaravai.usermicroservice.domain.User;
import com.solvd.ikaravai.usermicroservice.dto.UserAuthenticationDto;
import com.solvd.ikaravai.usermicroservice.dto.UserWithoutPasswordDto;
import com.solvd.ikaravai.usermicroservice.repository.UserRepository;
import com.solvd.ikaravai.usermicroservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/singup")
    @ResponseStatus(HttpStatus.CREATED)
    public User signUp(UserWithoutPasswordDto userWithoutPassword, @RequestBody String rawPassword) {
        return userService.save(userWithoutPassword, rawPassword);
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean singIn(UserAuthenticationDto userAuthenticationDto) {
        return Boolean.TRUE;
    }

    @GetMapping("/test/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
