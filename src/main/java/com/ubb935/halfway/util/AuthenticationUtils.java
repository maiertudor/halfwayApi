package com.ubb935.halfway.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author ciprian.mosincat on 11/12/2017.
 */
public final class AuthenticationUtils {

    public static final String DEFAULT_USER = "sys";

    public static String getLoggedInUser() {
//        return DEFAULT_USER;
        final Authentication authentication = getAuthentication();
        return authentication == null ? DEFAULT_USER : authentication.getName();
    }

    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
