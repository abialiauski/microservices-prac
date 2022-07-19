package org.micro.service.impl;

import org.micro.exception.UserNotFoundException;
import org.micro.model.User;
import org.micro.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Map<Long, User> idUserMap =
            Map.of(1L, new User(1L, "Ivan"),
                    2L, new User(2L, "Sveta"),
                    3L, new User(3L, "John"));
    private static final Map<String, User> nameUserMap = Map.of("Ivan", new User(1L, "Ivan"),
            "Sveta", new User(2L, "Sveta"),
            "John", new User(3L, "John"));

    @Override
    public User createUser(User user) {
        Map<Long, User> map = new HashMap<>(idUserMap);
        map.put(user.getId(), user);
        return map.get(user.getId());
    }

    @Override
    public User findByName(String name) {
        return Optional.of(nameUserMap.get(name))
                .orElseThrow(() -> new UserNotFoundException("user with name: " + name + " not found"));
    }

    @Override
    public User findById(Long id) {
        return Optional.of(idUserMap.get(id))
                .orElseThrow(() -> new UserNotFoundException("user with id: " + id + " not found"));
    }
}