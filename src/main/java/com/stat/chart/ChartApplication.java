package com.stat.chart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableCircuitBreaker
@EnableWebMvc
@SpringBootApplication
public class ChartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChartApplication.class, args);
	}
}
