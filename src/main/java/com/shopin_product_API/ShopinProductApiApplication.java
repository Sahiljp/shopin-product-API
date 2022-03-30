package com.shopin_product_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ShopinProductApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopinProductApiApplication.class, args);
	}

}
