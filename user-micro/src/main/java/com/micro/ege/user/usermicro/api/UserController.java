package com.micro.ege.user.usermicro.api;

import com.micro.ege.user.usermicro.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "User Microservice")
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService) {
        this.userMapper = Mappers.getMapper(UserMapper.class);
        this.userService = userService;
    }

    @Operation(summary = "Create Offer",description = "Create User")
    @ApiResponse(responseCode = "201", description = "Create User Response")
    @PostMapping(path = "/create")
    public ResponseEntity<CreateUserResponse> createUser(
            @Parameter(description = "Request object for create",required = true)
            @RequestBody CreateUserRequest createUserRequest) {
        return new ResponseEntity<CreateUserResponse>(userMapper.mapServiceOutputToApiResponse(
                userService.createUser(userMapper.mapApiRequestToServiceInput(
                        createUserRequest))), HttpStatus.CREATED);
    }
}
