package com.assignment.springboot.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class Myapplication {

	public static void main(String[] args) {
		SpringApplication.run(Myapplication.class, args);
	}
}