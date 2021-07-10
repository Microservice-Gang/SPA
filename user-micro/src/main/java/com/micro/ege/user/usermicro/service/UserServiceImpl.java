package com.micro.ege.user.usermicro.service;

import com.micro.ege.user.usermicro.dto.CreateUserDto;
import com.micro.ege.user.usermicro.repo.UserRepository;
import com.micro.ege.user.usermicro.repo.UserRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public CreateUserServiceOutput createUser(CreateUserServiceInput request) {
        CreateUserServiceOutput result = new CreateUserServiceOutput();
        CreateUserDto createUserDto = new CreateUserDto();
        createUserDto.setName(request.getName());
        createUserDto.setSurname(request.getSurname());
        createUserDto.setMail(request.getMail());
        createUserDto.setCipher(request.getCipher());


        result.setIsSucceeded(userRepository.createUser(createUserDto));
        result.setErrorCode(0L);
        result.setErrorMessage("İşlem Başarıyla Gerçekleştirildi.");
        return result;
    }
}
