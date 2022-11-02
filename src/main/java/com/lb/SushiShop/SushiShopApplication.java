package com.lb.SushiShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@SpringBootApplication
public class SushiShopApplication {
	@RequestMapping("/")
	String basicURL() {
		return "Welcome to Bill's Sushi Shop";
	}

	public static void main(String[] args) throws Exception{
		SpringApplication.run(SushiShopApplication.class, args);
	}

}
