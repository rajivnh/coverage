package com.lti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoverageApplication {

	@ExcludeFromJacocoGeneratedReport
	public static void main(String[] args) {
		SpringApplication.run(CoverageApplication.class, args);
	}
}
