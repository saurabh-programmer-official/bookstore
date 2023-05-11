package com.fabellus.mybootadminserver.MyBootAdminServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class MyBootAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBootAdminServerApplication.class, args);
	}

}
