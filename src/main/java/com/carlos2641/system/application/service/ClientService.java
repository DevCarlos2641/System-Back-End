package com.carlos2641.system.application.service;

import com.carlos2641.system.domain.model.Client;
import com.carlos2641.system.domain.port.in.ClientUseCase;
import com.carlos2641.system.domain.port.out.ClientRepositoryPort;
import com.carlos2641.system.infrastructure.in.dto.ClientDTO;
import com.carlos2641.system.infrastructure.out.persistence.Client.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService implements ClientUseCase {

    private final ClientRepositoryPort repositoryPort;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientDTO> getAll() {
        return clientsMapperDto(
                repositoryPort.getAll()
        );
    }

    @Override
    public ClientDTO getById(Long id) {
        return clientMapper.toDTO(repositoryPort.getById(id));
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        verifiedClientExist(clientDTO);
        Client client = repositoryPort.createClient(
                clientMapper.toDomain(clientDTO)
        );
        return clientMapper.toDTO(client);
    }

    @Override
    public void updateClient(ClientDTO clientDTO, Long id_client) {
        // Verified Client by email, tel, and rfc
        verifiedClientExist(clientDTO, id_client);
        repositoryPort.updateClient(
                clientMapper.toDomain(clientDTO),
                id_client
        );
    }

    @Override
    public void deleteClient(Long id_client) {
        repositoryPort.deleteClient(id_client);
    }

    public List<ClientDTO> clientsMapperDto(List<Client> clients){
        return clients.stream().map(clientMapper::toDTO).toList();
    }

    private void verifiedClientExist(ClientDTO clientDTO, Long id_client){
        repositoryPort.existsByEmailOrRfcOrTel(
                clientDTO.getEmail(),
                clientDTO.getRfc(),
                clientDTO.getTel(),
                id_client
        );
    }

    private void verifiedClientExist(ClientDTO clientDTO){
        repositoryPort.existsByEmailOrRfcOrTel(
                clientDTO.getEmail(),
                clientDTO.getRfc(),
                clientDTO.getTel()
        );
    }
}
