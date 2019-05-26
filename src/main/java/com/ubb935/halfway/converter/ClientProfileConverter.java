package com.ubb935.halfway.converter;

import com.ubb935.halfway.dto.ClientProfileDto;
import com.ubb935.halfway.model.ClientProfile;
import org.springframework.stereotype.Component;

/**
 * @author ciprian.mosincat on 11/11/2017.
 */
@Component
public class ClientProfileConverter extends BaseConverter<ClientProfile, ClientProfileDto> {

    @Override
    public ClientProfileDto convertModelToDto(final ClientProfile model) {
        final ClientProfileDto clientProfileDto = ClientProfileDto.builder()
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .email(model.getEmail()).build();
        clientProfileDto.setId(model.getId());
        return clientProfileDto;
    }

    @Override
    public ClientProfile convertDtoToModel(final ClientProfileDto dto) {
        return new ClientProfile(dto.getFirstName(), dto.getLastName(),
                dto.getEmail(), null);
    }

}
