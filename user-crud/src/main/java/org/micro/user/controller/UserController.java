package org.micro.user.controller;

import lombok.RequiredArgsConstructor;
import org.micro.user.model.User;
import org.micro.user.model.UserElastic;
import org.micro.user.repository.UserElasticRepository;
import org.micro.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserElasticRepository userElasticRepository;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/elastic/{name}")
    public UserElastic createUserElastic(@PathVariable String name) {
        return userElasticRepository.save(
                UserElastic
                        .builder()
                        .name(name)
                        .id(UUID.randomUUID().toString())
                        .build()
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/elastic")
    public Iterable<UserElastic> getAllUserElastic() {
        return userElasticRepository.findAll();
    }
}