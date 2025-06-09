package com.carlos2641.system.domain.port.out;

import com.carlos2641.system.domain.model.Client;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientRepositoryPort {
    List<Client> getAll();
    Client getById(Long id);
    Client createClient(Client client);
    void updateClient(Client client, Long id_client);
    void deleteClient(Long id_client);
    void existsByEmailOrRfcOrTel(String email, String rfc, String tel, Long id);
    void existsByEmailOrRfcOrTel(String email, String rfc, String tel);
}
