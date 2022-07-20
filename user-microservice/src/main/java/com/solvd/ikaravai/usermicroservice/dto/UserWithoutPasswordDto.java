package com.solvd.ikaravai.usermicroservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserWithoutPasswordDto {

    private String id;
    private String username;
}
