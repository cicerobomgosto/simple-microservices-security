package br.com.brdev2w.authenticationservice.feign;

import br.com.brdev2w.authenticationservice.dtos.ClienteDto;
import br.com.brdev2w.authenticationservice.service.UserDto;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient( name = "cliente-service", url = "http://localhost:8765/cliente-service")
public interface ClienteFeign {

  @PostMapping(value = "/clientes/registerCliente",
		consumes = { MediaType.APPLICATION_JSON_VALUE },
		produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<ClienteDto> registerCliente(@RequestBody ClienteDto clienteDto);

  @PostMapping(value = "/clientes/getClienteInfo",
		consumes = { MediaType.APPLICATION_JSON_VALUE },
		produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<?> getClienteInfo(@RequestBody UserDto userDto);

}
