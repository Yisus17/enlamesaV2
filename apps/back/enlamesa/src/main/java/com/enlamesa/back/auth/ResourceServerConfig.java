package com.enlamesa.back.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//rutas publicas
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/promo").permitAll() //todo lo que este debajo del api publico, es publico
		.antMatchers(HttpMethod.DELETE,"/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT,"/**").hasAnyRole("ADMIN", "EMPLEADO")
		.antMatchers(HttpMethod.POST,"/**").hasAnyRole("ADMIN", "EMPLEADO")
		.antMatchers(HttpMethod.GET,"api/users").authenticated()
		.anyRequest().permitAll(); //todas las demas rutas sin asignacion, exigir autenticacion
	}

	
	
}
