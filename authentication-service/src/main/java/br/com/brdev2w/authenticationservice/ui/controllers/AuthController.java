package br.com.brdev2w.authenticationservice.ui.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.brdev2w.authenticationservice.dtos.ClienteDto;
import br.com.brdev2w.authenticationservice.feign.services.ClienteService;
import br.com.brdev2w.authenticationservice.io.entities.RefreshToken;
import br.com.brdev2w.authenticationservice.io.entities.User;
import br.com.brdev2w.authenticationservice.io.repositories.UserRepository;
import br.com.brdev2w.authenticationservice.payload.HttpErrorResponse;
import br.com.brdev2w.authenticationservice.payload.JwtResponse;
import br.com.brdev2w.authenticationservice.payload.RefreshTokenResponse;
import br.com.brdev2w.authenticationservice.security.jwt.JwtUtil;
import br.com.brdev2w.authenticationservice.security.jwt.RefreshTokenService;
import br.com.brdev2w.authenticationservice.service.MyUserDetails;
import br.com.brdev2w.authenticationservice.service.UserDto;
import br.com.brdev2w.authenticationservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Tag( name = "Authentication Service - SignUp and SignIn")
@RestController
@RequestMapping("authentication-service")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private RefreshTokenService refreshTokenService;
	@Autowired
	private UserService userService;
	@Autowired
  	ClienteService clienteService;
	@Autowired
 	UserRepository userRepository;
	@Autowired
 	ModelMapper modelMapper;



	@Operation( summary = "Create a cliente.")
	@PostMapping("/auth/clienteRegister")
	public ResponseEntity<ClienteDto> clienteRegister(@RequestBody ClienteDto clienteDto){
	  clienteService.registerCliente(clienteDto);
	  User user = new User();
	  user.setPassword(clienteDto.getFpassword());
	  user.setUsername(clienteDto.getEmail());
	  User regUser = userService.findUserByUsername(user.getUsername());
	  if(regUser != null)
		return null;

	  userService.saveUser(user);

	  return ResponseEntity.status(201).body(clienteDto);
	}

	@Operation(summary = "Global authentication")
	@PostMapping("/auth/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDto user) throws Exception {
		Authentication auth = null;

		try {
			auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(401).body(new HttpErrorResponse("auth-001", "Invalid login credentials!"));
		}

		MyUserDetails myUserDetails = (MyUserDetails) auth.getPrincipal();
		final String jwt = jwtUtil.generateToken(myUserDetails);
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(myUserDetails.getId());
		List<String> roles = myUserDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());

		return ResponseEntity.status(200).body(new JwtResponse("Bearer", jwt, refreshToken.getRefreshToken(), myUserDetails.getUuid(), myUserDetails.getUsername(), roles));
	}

  @Operation(summary = "Register User **Deprecated**")
  @PostMapping("/auth/registerUser")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		User regUser = userService.findUserByUsername(user.getUsername());

		if(regUser != null)
			return ResponseEntity.status(409).body(new HttpErrorResponse("conflict", "User already exists!"));

		regUser = userService.saveUser(user);

		return ResponseEntity.status(201).body(regUser);
	}

  @Operation(summary = "Logout system")
	@PostMapping("/auth/invalidate")
	public ResponseEntity<?> invalidate(@RequestBody Map<String, Long> userid) {
		refreshTokenService.deleteByUserId(userid.get("id"));
		return ResponseEntity.status(200).body("User logged out");
	}

  @Operation(summary = "Refresh Token")
  @PostMapping("/auth/refreshtoken")
	public ResponseEntity<?> refreshtoken(@RequestBody Map<String, String> refreshToken) {
		RefreshToken token = refreshTokenService.findByRefreshToken(refreshToken.get("token"));

		if(token != null && refreshTokenService.verifyExpiration(token) != null) {
			User user = token.getUser();
			Map<String, Object> claims = new HashMap<>();
			claims.put("ROLES", user.getRoles().stream().map(item -> item.getRole()).collect(Collectors.toList()));
			String jwt = jwtUtil.createToken(claims, user.getUsername());

			return ResponseEntity.status(201).body(new RefreshTokenResponse("Bearer", jwt, refreshToken.get("token")));
		}

		return ResponseEntity.status(401).body(new HttpErrorResponse("auth-002", "Refresh token invalid!"));
	}

}