package com.dbapp.analyse.stream.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceException extends RuntimeException {
    private int code = 0;

    public ServiceException(String message) {
        super(message);
        this.code = -1;
    }

    public ServiceException(String message, Throwable e) {
        super(message, e);
        this.code = -1;
    }
}
