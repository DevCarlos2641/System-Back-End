package com.carlos2641.system.domain.port.in;

import com.carlos2641.system.domain.model.Client;
import com.carlos2641.system.infrastructure.in.dto.ClientDTO;

import java.net.URI;
import java.util.List;

public interface ClientUseCase {
    List<ClientDTO> getAll();
    ClientDTO getById(Long id);
    ClientDTO createClient(ClientDTO clientDTO);
    void updateClient(ClientDTO clientDTO, Long id_client);
    void deleteClient(Long id_client);
}