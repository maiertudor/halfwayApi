package com.ubb935.halfway.util;

import com.ubb935.halfway.util.enumeration.UserRole;

/**
 * @author ciprian.mosincat on 11/11/2017.
 */

public final class UserRoleUtils {

    public static String getRoleAsString(final UserRole role) {
        if (UserRole.CLIENT.equals(role)) {
            return "CLIENT";
        } else {
            return "PROVIDER";
        }
    }

}
