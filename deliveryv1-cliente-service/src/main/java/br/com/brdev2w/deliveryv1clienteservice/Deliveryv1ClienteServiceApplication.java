package br.com.brdev2w.deliveryv1clienteservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class Deliveryv1ClienteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Deliveryv1ClienteServiceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
	  return new ModelMapper();
	}

}