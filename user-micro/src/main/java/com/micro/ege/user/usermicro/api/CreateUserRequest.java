package com.micro.ege.user.usermicro.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateUserRequest {
    @NotNull(message = "Name is not null")
    @Schema(description = "Name", example = "Kenan", required = true)
    private String name;

    @NotNull(message = "Surname is not null")
    @Schema(description = "Advert ID", example = "Gülol", required = true)
    private String surname;

    @NotNull(message = "Mail Address is not null")
    @Schema(description = "Mail Address", example = "abc@gmail.com", required = true)
    private String mail;


    @NotNull(message = "Password is not null")
    @Schema(description = "Password", example = "dfh54dh5d3", required = true)
    private String cipher;
}
