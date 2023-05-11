package com.fabellus.microservices.bookprice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan
@EnableSwagger2
//@EnableFeignClients
//@EnableEurekaClient
//@EnableCircuitBreaker
@SpringBootApplication
@EnableWebMvc
public class MyBookPriceMainApplication {

	static Logger log = LoggerFactory.getLogger(MyBookPriceMainApplication.class);
	public static void main(String[]args) {
		SpringApplication.run(MyBookPriceMainApplication.class, args);
	}
}
