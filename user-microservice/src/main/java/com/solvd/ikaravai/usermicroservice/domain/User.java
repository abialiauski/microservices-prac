package com.solvd.ikaravai.usermicroservice.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("users")
public class User {

    private String id;
    private String username;
    private String password;
    private String role;
}
