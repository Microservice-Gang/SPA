package com.micro.ege.user.usermicro.dto;

import lombok.Data;

@Data
public class CreateUserDto {
    private String name;
    private String surname;
    private String mail;
    private String cipher;
}
