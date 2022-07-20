package com.solvd.ikaravai.usermicroservice.dto;

import lombok.Data;

@Data
public class UserAuthenticationDto {

    private String username;
    private String password;
}
