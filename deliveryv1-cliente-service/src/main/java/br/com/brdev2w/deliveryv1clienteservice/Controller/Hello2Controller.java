package br.com.brdev2w.deliveryv1clienteservice.Controller;

import br.com.brdev2w.deliveryv1clienteservice.Feign.HelloFeign;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Hello test controller swagger")
@RestController
@RequestMapping("cliente-service")
public class Hello2Controller {

    Logger logger = LoggerFactory.getLogger(Hello2Controller.class);

    @Autowired
    private HelloFeign helloFeign;

    @Autowired
    Environment environment;

    @GetMapping("/clienteTeste")
    public String testando(){
        return "AAAAAAAAAAAAAAAAAA FUNCIONOU!!!!";
    }

    @Operation(summary = "testa o feign com o mercado-service")
    @GetMapping("/api/v1/cliente/hello")
    public String helloMercado2()
    {
        logger.info("Logger agora amostra id(hash) de cada transacao para acompanhar nos logs!");
        var port2 = environment.getProperty("local.server.port");
        return helloFeign.helloMercado() + " -- Testando LoadBalance - Cliente Service: " + port2;
    }

}
