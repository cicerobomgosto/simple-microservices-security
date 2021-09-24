package br.com.brdev2w.authenticationservice.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authentication-service")
public class TesteController {

  @Autowired
  Environment environment;
	//DELETAR CONTROLLER
	@GetMapping("/teste/teste")
	public String helloMercado(){
	  var port2 = environment.getProperty("local.server.port");

	  return  " " + " Testando Load Balance - Authentication Service: " + port2;
	}
}
