package org.ibayer.personel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Application class representing both spring boot and spring configuration.
 * 
 * @author ibrahim.bayer
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableSwagger2
public class Application {
	/**
	 * Application runner main method. {@link SpringApplication} run method is
	 * executed internally
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Basic configuration example to manage Jackson Object Mapper, no
	 * configuration yet
	 * 
	 * @return
	 */
	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
	
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()                                       
	      .apis(RequestHandlerSelectors.basePackage("org.ibayer.personel.api"))
	      .build();
	}
	
}
