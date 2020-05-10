package com.in28mins.springboot.springbootsecondwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication(scanBasePackages = {"com.in28mins.springboot.user"})
 * 
 * NOTE: Using scanBasePackages allows us to keep our controllers in different packages.
 * Just mention all the package names within the curly brackets
 */
@SpringBootApplication(scanBasePackages = {"com.in28mins.springboot.user", "com.in28mins.springboot.tweet"})
public class SpringBootSecondWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecondWebAppApplication.class, args);
	}

}
