package com.example.Shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ShopApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ShopApplication.class, args);
	}

}
	