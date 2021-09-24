package br.com.brdev2w.deliveryv1clienteservice.security;

import br.com.brdev2w.deliveryv1clienteservice.security.filters.JwtRequestFilter;
import br.com.brdev2w.deliveryv1clienteservice.service.auth.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
@SuppressWarnings("deprecation")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.cors().and()
				.csrf().disable()
				.authorizeRequests()
			  .antMatchers("/swagger-ui/**").permitAll()
			  .antMatchers("/cliente-service/swagger-ui.html").permitAll()
			  .antMatchers("/swagger-resources/**").permitAll()
			  .antMatchers("/webjars/**").permitAll()
			  .antMatchers("/v3/api-docs/**").permitAll()
			  .antMatchers("/").permitAll()
			  .antMatchers("/csrf").permitAll()
			  .antMatchers("/*.js").permitAll()
			  .antMatchers("/*.css").permitAll()
			  .antMatchers("/*.ico").permitAll()
			  .antMatchers("/*.png").permitAll()
				.antMatchers("/cliente-service/api/v1/**" +
					  "/cliente-service/clientes/registerCliente").permitAll()
			  .antMatchers("/cliente-service/clientes/registerCliente").permitAll()
			  .antMatchers("/cliente-service/clientes/getClienteInfo").permitAll()
				.antMatchers("/cliente-service/clienteTeste").hasAnyRole( "USER")
			  .anyRequest().authenticated();

		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		http.headers().frameOptions().disable();
	}

}