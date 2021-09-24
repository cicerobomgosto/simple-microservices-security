package br.com.brdev2w.deliveryv1clienteservice.Controller;

import br.com.brdev2w.deliveryv1clienteservice.Dto.ClienteDto;
import br.com.brdev2w.deliveryv1clienteservice.service.auth.UserDto;
import br.com.brdev2w.deliveryv1clienteservice.service.interfaces.IClienteService;
import br.com.brdev2w.deliveryv1clienteservice.ui.responses.ClienteRegisterResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag( name = "Cliente Service SignUP")
@RestController()
@RequestMapping("cliente-service")
public class SignUpController {

  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  private IClienteService clienteService;

  @Operation(summary = "")
  @PostMapping("/clientes/registerCliente")
  public ResponseEntity<ClienteDto> registerCliente(@RequestBody ClienteDto clienteDto){

	clienteService.createClienteService(clienteDto);
	clienteDto.setFpassword("**********");
	return ResponseEntity.ok(clienteDto);
  }
  
}
