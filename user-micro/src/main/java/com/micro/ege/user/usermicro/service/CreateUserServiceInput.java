package com.micro.ege.user.usermicro.service;

import lombok.Data;

@Data
public class CreateUserServiceInput {
    private String name;
    private String surname;
    private String mail;
    private String cipher;
}
