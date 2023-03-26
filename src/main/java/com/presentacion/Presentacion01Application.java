package com.presentacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
//@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
public class Presentacion01Application {

	public static void main(String[] args) {
		SpringApplication.run(Presentacion01Application.class, args);
	}

}
