package br.com.brdev2w.deliveryv1namingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Deliveryv1NamingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Deliveryv1NamingServiceApplication.class, args);
	}

}
