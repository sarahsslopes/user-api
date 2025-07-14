package com.minsait.user_api.application.dtos;

import com.minsait.user_api.domain.entities.UserEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto {

    public String id;
    public String name;
    public String email;

    public UserDto(UserEntity user) {
        this.id = user.getId().toString();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
