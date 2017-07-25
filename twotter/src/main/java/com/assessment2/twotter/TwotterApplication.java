package com.assessment2.twotter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class TwotterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwotterApplication.class, args);
	}
}
