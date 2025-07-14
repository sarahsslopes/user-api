package com.minsait.user_api.utils.exceptions;

import lombok.Getter;

@Getter
public class ResourceNotFound extends RuntimeException {

    private final String id;

    public ResourceNotFound(String message, String id) {
        super(message);
        this.id = id;
    }
}
