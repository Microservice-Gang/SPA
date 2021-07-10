package com.micro.ege.user.usermicro.api;

import com.micro.ege.user.usermicro.service.*;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    public CreateUserServiceInput mapApiRequestToServiceInput(CreateUserRequest createOfferRequest);
    public UpdateUserServiceInput mapApiRequestToServiceInput(UpdateUserRequest updateOfferRequest);
    public GetUserServiceInput mapApiRequestToServiceInput(GetUserRequest getUserRequest);

    public CreateUserResponse mapServiceOutputToApiResponse(CreateUserServiceOutput createUserOutput);
    public UpdateUserResponse mapServiceOutputToApiResponse(UpdateUserServiceOutput updateUserOutput);
    public GetUserResponse mapServiceOutputToApiResponse(GetUserServiceOutput getUserOutput);
}
