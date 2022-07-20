package org.micro.user.controller;

import lombok.RequiredArgsConstructor;
import org.micro.user.model.User;
import org.micro.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Flux<User> getAll() {
        return userRepository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Mono<User> getById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/name")
    public Mono<User> getByName(@RequestParam String name) {
        return userRepository.findByName(name);
    }
}