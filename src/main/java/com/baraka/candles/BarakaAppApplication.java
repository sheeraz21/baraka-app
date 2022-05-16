package com.baraka.candles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication

@EnableCaching
public class BarakaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarakaAppApplication.class, args);
	}

}
