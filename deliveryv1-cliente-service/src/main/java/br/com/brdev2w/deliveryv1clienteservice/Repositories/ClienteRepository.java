package br.com.brdev2w.deliveryv1clienteservice.Repositories;

import br.com.brdev2w.deliveryv1clienteservice.Entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    List<ClienteEntity> findAllById(Long id);
    ClienteEntity findByUsername(String username);
    boolean existsByUsername(String username);
}
