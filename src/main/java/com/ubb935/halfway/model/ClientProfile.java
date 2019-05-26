package com.ubb935.halfway.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author ciprian.mosincat on 11/1/2017.
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
@DiscriminatorValue("client")
public class ClientProfile extends Profile {

    private static final long serialVersionUID = -2860589628925188462L;

    public ClientProfile(final String firstName, final String lastName, final String email, final Account account) {
        super(firstName, lastName, email, account);
    }
}
