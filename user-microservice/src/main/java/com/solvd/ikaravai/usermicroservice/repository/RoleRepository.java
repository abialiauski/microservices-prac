package com.solvd.ikaravai.usermicroservice.repository;

import com.solvd.ikaravai.usermicroservice.domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends MongoRepository<Role, String> {
}


