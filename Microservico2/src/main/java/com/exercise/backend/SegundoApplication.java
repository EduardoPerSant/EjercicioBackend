package com.exercise.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.exercise.backend.remoto.repository")
public class SegundoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SegundoApplication.class, args);
	}

}
