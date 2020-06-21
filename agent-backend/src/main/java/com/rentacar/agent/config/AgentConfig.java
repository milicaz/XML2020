package com.rentacar.agent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.rentacar.agent.model.GetPorukaRequest;

@Configuration
public class AgentConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		System.out.println("package name: " + GetPorukaRequest.class.getPackage().getName());
		marshaller.setContextPath(GetPorukaRequest.class.getPackage().getName());
		return marshaller;
	}
}
