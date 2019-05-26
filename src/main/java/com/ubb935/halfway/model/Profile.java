package com.ubb935.halfway.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author ciprian.mosincat on 11/1/2017.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "profiles")
@Inheritance
public class Profile extends BaseEntity {

    private static final long serialVersionUID = -2984006037953748652L;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(nullable = false)
    private Account account;

}
