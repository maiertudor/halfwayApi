package com.ubb935.halfway.service.exception;

import com.ubb935.halfway.util.enumeration.ValidationCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author ciprian.mosincat on 11/11/2017.
 */
public class ValidationException extends Exception {

    public ValidationException(final String message) {
        super(message);
    }

}

