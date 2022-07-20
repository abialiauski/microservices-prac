package com.solvd.ikaravai.usermicroservice.repository;

import com.solvd.ikaravai.usermicroservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);
}