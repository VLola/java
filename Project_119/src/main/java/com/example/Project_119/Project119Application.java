package com.example.Project_119;

import com.example.Project_119.controllers.WebController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Project119Application {

	public static void main(String[] args)
	{
		new WebController();
		SpringApplication.run(Project119Application.class, args);
	}
//
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/getMoonPhase").allowedOrigins("http://localhost:8080");
//			}
//		};
//	}
}
