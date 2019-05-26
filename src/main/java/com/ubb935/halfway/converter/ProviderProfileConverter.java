package com.ubb935.halfway.converter;

import com.ubb935.halfway.dto.ProviderProfileDto;
import com.ubb935.halfway.model.ProviderProfile;
import org.springframework.stereotype.Component;

/**
 * @author ciprian.mosincat on 11/12/2017.
 */
@Component
public class ProviderProfileConverter extends BaseConverter<ProviderProfile, ProviderProfileDto> {

    @Override
    public ProviderProfileDto convertModelToDto(final ProviderProfile model) {
        final ProviderProfileDto providerProfileDto = ProviderProfileDto.builder()
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .email(model.getEmail())
                .abilities(model.getAbilities()).build();
        providerProfileDto.setId(model.getId());
        return providerProfileDto;
    }

    @Override
    public ProviderProfile convertDtoToModel(final ProviderProfileDto dto) {
        return new ProviderProfile(dto.getFirstName(), dto.getLastName(), dto.getEmail(), null, dto.getAbilities());
    }

}
