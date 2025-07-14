package com.minsait.user_api.domain.entities;

import com.minsait.user_api.application.dtos.CreateUserDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "user", schema = "public")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class UserEntity {

    @Id
    @Column(unique = true, nullable = false)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;


    public static UserEntity create(CreateUserDto createUserDto) {
        return new UserEntity(
                UUID.randomUUID(),
                createUserDto.getName(),
                createUserDto.getEmail()
        );
    }
}

