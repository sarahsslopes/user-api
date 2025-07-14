package com.minsait.user_api.application.controllers.user;

import com.minsait.user_api.application.dtos.*;
import com.minsait.user_api.application.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody CreateUserDto createUserDto) {
        return userService.save(createUserDto);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable GetUserDto id) {
        return userService.get(id);
    }

    @GetMapping
    public List<UserDto> listUsers() {
        return userService.list();
    }

    @PutMapping("/{id}")
    public UserDto updateUser(
            @PathVariable String id,
            @RequestBody UpdateUserDto updateUserDto
    ) {
        return userService.update(id, updateUserDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable DeleteUserDto id) {
        userService.delete(id);
    }
}
