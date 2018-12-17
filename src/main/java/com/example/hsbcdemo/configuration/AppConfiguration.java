package com.example.hsbcdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.hsbcdemo.outgoing.response.model.TaxComponent;

@Configuration
public class AppConfiguration {

	@Bean
	@Scope("prototype")
	public TaxComponent taxComponent() {
		return new TaxComponent();
	}

}
