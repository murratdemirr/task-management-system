package com.demir.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration  // Sprint Boot Auto Configuration
@EnableJpaRepositories("com.demir.tms.control")
@ComponentScan(basePackages = "com.demir.tms")
public class TmsBackendApplication {


	public static void main(String[] args) {
		SpringApplication.run(TmsBackendApplication.class, args);
	}


}
