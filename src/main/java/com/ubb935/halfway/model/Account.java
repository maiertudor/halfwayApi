package com.ubb935.halfway.model;

import com.ubb935.halfway.util.enumeration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {

    private static final long serialVersionUID = 4439708628675069802L;

    @Column(unique = true)
    String username;

    String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

}
