package com.enlamesa.back.auth;

import java.util.Arrays;

import org.aspectj.weaver.ast.And;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//rutas publicas
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/promo").permitAll() //todo lo que este debajo del api publico, es publico
//		.antMatchers(HttpMethod.DELETE,"/**").hasRole("ADMIN")
//		.antMatchers(HttpMethod.PUT,"/**").hasAnyRole("ADMIN", "EMPLEADO")
//		.antMatchers(HttpMethod.POST,"/**").hasAnyRole("ADMIN", "EMPLEADO")
//		.antMatchers(HttpMethod.GET,"api/users").authenticated()
		.anyRequest().authenticated()
		.and()
		.cors().configurationSource(corsConfigurationSource()); //todas las demas rutas sin asignacion, exigir autenticacion
	}

	
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200")); //angular
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Content-type","Authorization"));
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

	//filtro de CORS (cross origin)
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
		
	}
	
}
