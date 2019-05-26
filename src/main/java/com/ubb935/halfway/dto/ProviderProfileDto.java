package com.ubb935.halfway.dto;

import com.ubb935.halfway.model.enumerations.Ability;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ciprian.mosincat on 11/11/2017.
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProviderProfileDto extends ProfileDto {

    private static final long serialVersionUID = -2563244208354810774L;

    private List<Ability> abilities = new ArrayList<>();

    @Builder
    public ProviderProfileDto(final String firstName, final String lastName, final String email, final List<Ability> abilities) {
        super(firstName, lastName, email);
        this.abilities = abilities;
    }

}
