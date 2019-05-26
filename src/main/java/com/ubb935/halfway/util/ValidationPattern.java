package com.ubb935.halfway.util;

import lombok.experimental.UtilityClass;

/**
 * @author ciprian.mosincat on 11/1/2017.
 */
@UtilityClass
public class ValidationPattern {

    public static final String NAME_PATTERN = "^[A-Za-z\\s]+";
    public static final String EMAIL_PATTERN = ".+@.+\\.[a-z]+";
    public static final int USERNAME_MAX_LENGTH = 10;
    public static final int USERNAME_MIN_LENGTH = 4;
    public static final int PASSWORD_MIN_LENGTH = 6;

}
