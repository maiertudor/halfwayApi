package com.ubb935.halfway.util.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ciprian.mosincat on 11/11/2017.
 */
@Getter
@AllArgsConstructor
public enum ValidationCode {

    CODE101("Duplicate username!"),
    CODE102("There already exists a profile for this user account!"),
    CODE103("There is no profile for this account. Please create a profile!"),
    CODE104("You must have an account to create a profile!"),
    CODE105("You should create a profile based on your account role!"),
    CODE106("You do not have a profile. Please create one!");

    private String message;

}
