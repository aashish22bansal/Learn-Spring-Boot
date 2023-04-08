package com.aashish22bansal.developer.learning.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.Class})
public class SpringBootRestcrudapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestcrudapiApplication.class, args);
	}

}
