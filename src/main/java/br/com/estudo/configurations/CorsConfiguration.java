package br.com.estudo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
	 @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {

	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**") // aplica a todos os endpoints
	                        .allowedOrigins("http://localhost:4200") // origem do seu Angular
	                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	                        .allowedHeaders("*")
	                        .allowCredentials(true); // se usa cookies, auth, etc
	            }
	        };
	    }
}
