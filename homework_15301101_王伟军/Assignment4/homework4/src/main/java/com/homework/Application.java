package com.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author wangweijun
 */
@SpringBootApplication
@EnableWebFlux
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
