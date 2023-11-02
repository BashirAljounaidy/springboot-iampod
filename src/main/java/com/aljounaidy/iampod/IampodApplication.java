package com.aljounaidy.iampod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class IampodApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(IampodApplication.class, args);
	}
}
