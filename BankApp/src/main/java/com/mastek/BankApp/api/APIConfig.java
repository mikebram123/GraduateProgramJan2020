package com.mastek.BankApp.api;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mastek.BankApp.services.BankAppServices;

@Component
public class APIConfig extends ResourceConfig {
	
	public APIConfig() {
		register(BankAppServices.class);
		register(CORSFilter.class);
	}
}
