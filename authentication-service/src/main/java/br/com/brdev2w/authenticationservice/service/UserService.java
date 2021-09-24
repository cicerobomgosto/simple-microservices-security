package br.com.brdev2w.authenticationservice.service;

import java.util.Arrays;

import br.com.brdev2w.authenticationservice.io.entities.Role;
import br.com.brdev2w.authenticationservice.io.entities.User;
import br.com.brdev2w.authenticationservice.io.repositories.RoleRepository;
import br.com.brdev2w.authenticationservice.io.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User findUserByUsername(String username) {
		return userRepository.findByUsernameIgnoreCase(username.toLowerCase());
	}

	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role userRole = roleRepository.findByRole("ROLE_USER");
		user.setRoles(Arrays.asList(userRole));

		return user = userRepository.save(user);
	}

	public User saveAdmin(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role adminRole = roleRepository.findByRole("ROLE_ADMIN");
		user.setRoles(Arrays.asList(adminRole));

		return user = userRepository.save(user);
	}

}