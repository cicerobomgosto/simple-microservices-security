package br.com.brdev2w.authenticationservice.io.repositories;

import br.com.brdev2w.authenticationservice.io.entities.RefreshToken;
import br.com.brdev2w.authenticationservice.io.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;


@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

	RefreshToken findByRefreshToken(String token);

	@Modifying
	int deleteByUser(User user);
}
