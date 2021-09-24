package br.com.brdev2w.authenticationservice.io.repositories;

import br.com.brdev2w.authenticationservice.io.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Boolean existsByUsernameIgnoreCase(String username);

	User findByUsernameIgnoreCase(String username);
}
