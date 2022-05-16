package com.droolConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class DroolConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroolConfigServerApplication.class, args);
	}

}
