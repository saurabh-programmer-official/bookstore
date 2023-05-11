package com.fabellus.placeorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

public class PlaceOrderApplication {

	static Logger log = LoggerFactory.getLogger(PlaceOrderApplication.class);
	public static void main(String[]args) {
		log.info("Start of Application");
		SpringApplication.run(PlaceOrderApplication.class, args);
		log.info("End of the Application");
	}
}
