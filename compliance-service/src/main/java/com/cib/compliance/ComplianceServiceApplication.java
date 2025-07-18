package com.cib.compliance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ComplianceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComplianceServiceApplication.class, args);
	}
}