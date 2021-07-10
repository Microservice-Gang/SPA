package com.micro.ege.user.usermicro.repo;

import com.micro.ege.user.usermicro.dto.CreateUserDto;
import com.micro.ege.user.usermicro.dto.UserDetailDto;

public interface UserRepository {
    UserDetailDto getUserWithId(String userId);
    UserDetailDto getUserWithMail(String mail);

    Boolean createUser(CreateUserDto createUserDto);
}
