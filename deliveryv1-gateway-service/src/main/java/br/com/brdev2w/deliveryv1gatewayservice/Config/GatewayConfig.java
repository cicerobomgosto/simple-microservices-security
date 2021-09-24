package br.com.brdev2w.deliveryv1gatewayservice.Config;

import br.com.brdev2w.deliveryv1gatewayservice.filters.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class GatewayConfig {

	@Autowired
	private JwtAuthenticationFilter filter;

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("authentication-service", r -> r.path("/authentication-service/**").filters(f -> f.filter(filter)).uri("lb://authentication-service"))
				.route("cliente-service", r -> r.path("/cliente-service/**").filters(f -> f.filter(filter)).uri("lb://cliente-service"))
				.build();
	}

}