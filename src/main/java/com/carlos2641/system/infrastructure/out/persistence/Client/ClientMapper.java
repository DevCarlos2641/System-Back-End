package com.carlos2641.system.infrastructure.out.persistence.Client;

import com.carlos2641.system.domain.model.Client;
import com.carlos2641.system.infrastructure.in.dto.ClientDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO toDTO(Client client);
    Client toDomain(ClientDTO dto);

    ClientEntity toEntity(Client client);
    Client toDomain(ClientEntity entity);

    ClientEntity toEntity(ClientDTO dto);
    ClientDTO toDTO(ClientEntity entity);

    List<ClientDTO> toDTOList(List<Client> clients);
}
