package com.carlos2641.system.infrastructure.out.persistence.Client;

import com.carlos2641.system.domain.model.Client;
import com.carlos2641.system.domain.port.out.ClientRepositoryPort;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ClientPersistenceAdapter implements ClientRepositoryPort {

    private final ClientJpaRepository jpaRepository;
    private final ClientMapper mapper;

    @Override
    public List<Client> getAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Client getById(Long id) {
        ClientEntity clientEntity = getClientEntity(id);
        return mapper.toDomain(clientEntity);
    }

    @Override
    public Client createClient(Client client) {
        ClientEntity clientEntity = mapper.toEntity(client);
        clientEntity =  jpaRepository.save(clientEntity);
        return mapper.toDomain(clientEntity);
    }

    @Override
    public void updateClient(Client client, Long id_client) {
        ClientEntity clientEntity = getClientEntity(id_client);

        clientEntity.setName(client.getName());
        clientEntity.setRfc(client.getRfc());
        clientEntity.setRegimen(client.getRegimen());
        clientEntity.setLegal_name(client.getLegal_name());
        clientEntity.setAddress(client.getAddress());
        clientEntity.setCp(client.getCp());
        clientEntity.setEmail(client.getEmail());
        clientEntity.setTel(client.getTel());
        jpaRepository.save(clientEntity);
    }

    @Override
    public void deleteClient(Long id_client) {
        // TODO: Implementar lógica de eliminación (soft delete o hard delete)
    }

    @Override
    public void existsByEmailOrRfcOrTel(String email, String rfc, String tel, Long id) {
        boolean exist = jpaRepository.existsByEmailOrRfcOrTel(email, rfc, tel, id);
        if(exist) throw new EntityExistsException("client exist by email, tel or rfc");
    }

    @Override
    public void existsByEmailOrRfcOrTel(String email, String rfc, String tel) {
        boolean exist = jpaRepository.existsByEmailOrRfcOrTel(email, rfc, tel);
        if(exist) throw new EntityExistsException("client exist by email, tel or rfc");
    }

    private ClientEntity getClientEntity(Long id){
        return jpaRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Not found client by id: " +id)
        );
    }
}
