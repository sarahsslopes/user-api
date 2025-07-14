package com.minsait.user_api.application.user.services;

import com.minsait.user_api.application.dtos.*;
import com.minsait.user_api.domain.UserRepository;
import com.minsait.user_api.domain.entities.UserEntity;
import com.minsait.user_api.utils.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service()
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto save(CreateUserDto createUserDto) {
        UserEntity user = UserEntity.create(createUserDto);

        userRepository.save(user);

        return new UserDto(user);
    }

    public UserDto update(String id, UpdateUserDto updateUserDto) {
        UserEntity user = userRepository.findById(id).get();

        user.setName(updateUserDto.getName());
        user.setEmail(updateUserDto.getEmail());

        userRepository.save(user);

        return new UserDto(user);
    }

    public UserDto get(GetUserDto getUserDto) {
        UserEntity user = userRepository.findById(getUserDto.getId())
                .orElseThrow(() -> new ResourceNotFound("User not found.", getUserDto.getId()));

        return new UserDto(user);
    }

    public List<UserDto> list() {
        return userRepository.findAll()
                .stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    public void delete(DeleteUserDto deleteUserDto) {
        UserEntity user = userRepository.findById(deleteUserDto.getId())
                .orElseThrow(() -> new ResourceNotFound("Unable to delete user.", deleteUserDto.getId()));

        userRepository.delete(user);
    }
}
