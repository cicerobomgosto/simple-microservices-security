package br.com.brdev2w.deliveryv1clienteservice.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient( name = "authentication-service", url = "http://localhost:8765/authentication-service")
public interface HelloFeign {

    @GetMapping("/teste/teste")
    public String helloMercado();
}
