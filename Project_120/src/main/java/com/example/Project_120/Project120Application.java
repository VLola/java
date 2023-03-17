package com.example.Project_120;

import com.example.Project_120.controller.WebController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project120Application {

	public static void main(String[] args) {
		SpringApplication.run(Project120Application.class, args);
		new WebController();
	}

}
