package com.fabellus.booksearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/*
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
*/
@SpringBootApplication
@EnableFeignClients
public class BookSearchApplication {

	static Logger log = LoggerFactory.getLogger(BookSearchApplication.class);
	public static void main(String[]args) {
		log.info("Start of Application");
		SpringApplication.run(BookSearchApplication.class, args);
		log.info("End of the Application");
	}
	
	
	
}
