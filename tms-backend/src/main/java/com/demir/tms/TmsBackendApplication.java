package com.demir.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAutoConfiguration  // Sprint Boot Auto Configuration
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableJpaRepositories("com.demir.tms.control")
@ComponentScan(basePackages = "com.demir.tms")
@EnableScheduling
public class TmsBackendApplication {


	public static void main(String[] args) {
		SpringApplication.run(TmsBackendApplication.class, args);
	}


}
