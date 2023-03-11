package com.example.Project_119;

import com.example.Project_119.controllers.WebController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project119Application {

	public static void main(String[] args)
	{
		new WebController();
		SpringApplication.run(Project119Application.class, args);
	}

}
