package br.com.brdev2w.authenticationservice.security;

import br.com.brdev2w.authenticationservice.security.jwt.JwtRequestFilter;
import br.com.brdev2w.authenticationservice.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

//	@Bean
//  CorsConfigurationSource corsConfigurationSource() {
//      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//      source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//      return source;
//  }

	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder());
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.cors().and()
				.csrf().disable()
				.authorizeRequests()
			  .antMatchers("/swagger-ui/**").permitAll()
			  .antMatchers("/authentication-service/swagger-ui.html").permitAll()
			  .antMatchers("/swagger-resources/**").permitAll()
			  .antMatchers("/webjars/**").permitAll()
			  .antMatchers("/v3/api-docs/**").permitAll()
			  .antMatchers("/").permitAll()
			  .antMatchers("/csrf").permitAll()
			  .antMatchers("/*.js").permitAll()
			  .antMatchers("/*.css").permitAll()
			  .antMatchers("/*.ico").permitAll()
			  .antMatchers("/*.png").permitAll()
				.antMatchers("/authentication-service/auth/**").permitAll()
			  .antMatchers("/authentication-service/v3/**").permitAll()
				.antMatchers("/authentication-service/teste/**").hasAnyRole("USER")
			  	.antMatchers("/cliente-service/clientes/**").permitAll()
			  	.anyRequest().authenticated()
				.and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		http.headers().frameOptions().disable();

	}

}