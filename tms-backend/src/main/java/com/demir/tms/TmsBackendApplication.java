package com.demir.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class TmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmsBackendApplication.class, args);
	}
}
