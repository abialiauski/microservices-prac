package org.micro.service;

import org.micro.model.User;

public interface UserService {

    User createUser(User user);

    User findByName(String name);

    User findById(Long id);
}