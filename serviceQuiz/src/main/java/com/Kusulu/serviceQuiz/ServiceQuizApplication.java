package com.Kusulu.serviceQuiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceQuizApplication.class, args);
	}

}
