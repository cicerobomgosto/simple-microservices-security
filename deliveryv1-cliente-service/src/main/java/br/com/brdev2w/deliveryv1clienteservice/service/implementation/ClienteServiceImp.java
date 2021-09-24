package br.com.brdev2w.deliveryv1clienteservice.service.implementation;

import br.com.brdev2w.deliveryv1clienteservice.Dto.ClienteDto;
import br.com.brdev2w.deliveryv1clienteservice.Entities.ClienteEntity;
import br.com.brdev2w.deliveryv1clienteservice.Repositories.ClienteRepository;
import br.com.brdev2w.deliveryv1clienteservice.service.auth.UserDto;
import br.com.brdev2w.deliveryv1clienteservice.service.interfaces.IClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImp implements IClienteService {

  @Autowired
  private ClienteRepository clienteRepository;
  @Autowired
  private ModelMapper modelMapper;

  @Override
  public ResponseEntity<ClienteDto> createClienteService(ClienteDto clienteDto) {
	ClienteEntity cliente = new ClienteEntity();
	boolean exists = clienteRepository.existsByUsername(cliente.getUsername());
	if(!exists){
	  cliente = modelMapper.map(clienteDto, ClienteEntity.class);
	  cliente.setUsername(cliente.getEmail());
	  clienteRepository.save(cliente);
	  return ResponseEntity.ok(clienteDto);
	}


	return ResponseEntity.ok(clienteDto);
  }

}
