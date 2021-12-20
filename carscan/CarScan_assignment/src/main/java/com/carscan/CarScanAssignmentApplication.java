package com.carscan;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarScanAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarScanAssignmentApplication.class, args);
		System.err.println("Welcome to users pannel of CarScan.co");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
