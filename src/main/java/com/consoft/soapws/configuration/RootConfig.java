package com.consoft.soapws.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.consoft.soapws.service.CustomerServices;

@Configuration
@ComponentScan({"com.consoft.soapws.service"})
public class RootConfig {
	@Bean
	public CustomerServices customerServices() {
		return new CustomerServices();
	}
}
