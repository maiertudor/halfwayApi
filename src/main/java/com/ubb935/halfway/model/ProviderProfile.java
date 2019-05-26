package com.ubb935.halfway.model;

import com.ubb935.halfway.model.enumerations.Ability;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author ciprian.mosincat on 11/1/2017.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("provider")
public class ProviderProfile extends Profile {

    private static final long serialVersionUID = 2657104624176027096L;
    @ElementCollection(targetClass = Ability.class)
    @JoinTable(name = "ability", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "ability", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Ability> abilities;

    public ProviderProfile(final String firstName, final String lastName, final String email, final Account account, final List<Ability> abilities) {
        super(firstName, lastName, email, account);
        this.abilities = abilities;
    }

}
