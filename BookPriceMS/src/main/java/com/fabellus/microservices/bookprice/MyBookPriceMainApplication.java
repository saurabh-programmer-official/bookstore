package com.fabellus.microservices.bookprice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class MyBookPriceMainApplication {

	static Logger log = LoggerFactory.getLogger(MyBookPriceMainApplication.class);
	public static void main(String[]args) {
		SpringApplication.run(MyBookPriceMainApplication.class, args);
	}
}
