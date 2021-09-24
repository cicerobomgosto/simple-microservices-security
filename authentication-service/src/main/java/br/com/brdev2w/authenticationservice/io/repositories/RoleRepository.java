package br.com.brdev2w.authenticationservice.io.repositories;

import br.com.brdev2w.authenticationservice.io.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByRole(String role);
}
