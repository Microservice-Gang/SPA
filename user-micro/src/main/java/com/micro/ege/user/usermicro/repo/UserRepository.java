package com.micro.ege.user.usermicro.repo;

import com.micro.ege.user.usermicro.dto.UserDetailDto;

public interface UserRepository {
    UserDetailDto getUserWithId(String userId);
    UserDetailDto getUserWittMail(String mail);
}
