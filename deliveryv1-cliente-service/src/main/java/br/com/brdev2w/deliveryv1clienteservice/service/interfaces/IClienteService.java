package br.com.brdev2w.deliveryv1clienteservice.service.interfaces;

import br.com.brdev2w.deliveryv1clienteservice.Dto.ClienteDto;
import br.com.brdev2w.deliveryv1clienteservice.Entities.ClienteEntity;
import br.com.brdev2w.deliveryv1clienteservice.service.auth.UserDto;
import org.springframework.http.ResponseEntity;

public interface IClienteService {
  ResponseEntity<ClienteDto> createClienteService(ClienteDto clienteDto);
}
