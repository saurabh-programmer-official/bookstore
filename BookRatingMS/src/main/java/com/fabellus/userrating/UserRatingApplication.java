package com.fabellus.userrating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
@EnableFeignClients
@EnableEurekaClient
public class UserRatingApplication {

	static Logger log = LoggerFactory.getLogger(UserRatingApplication.class);
	public static void main(String[]args) {
		log.info("Start of Application");
		SpringApplication.run(UserRatingApplication.class, args);
		log.info("End of the Application");
	}
}
