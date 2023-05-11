package com.fabellus.bookstoreweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class BookStoreWebMainApplication {

	static Logger log = LoggerFactory.getLogger(BookStoreWebMainApplication.class);
	public static void main(String[]args) {
		SpringApplication.run(BookStoreWebMainApplication.class, args);
	}
}
