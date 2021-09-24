package br.com.brdev2w.authenticationservice.feign.services;

import br.com.brdev2w.authenticationservice.dtos.ClienteDto;
import br.com.brdev2w.authenticationservice.feign.ClienteFeign;
import br.com.brdev2w.authenticationservice.service.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

  @Autowired
  private ClienteFeign clienteFeign;

	public ResponseEntity<ClienteDto> registerCliente(ClienteDto clienteDto){
		return clienteFeign.registerCliente(clienteDto);
	}

	public ResponseEntity<?> getClienteInfo(UserDto userDto){
	  return clienteFeign.getClienteInfo(userDto);
	}
}
