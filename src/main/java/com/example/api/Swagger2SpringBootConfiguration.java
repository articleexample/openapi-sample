package com.example.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger2SpringBootConfiguration {
	
	@Bean
	FamilyApiDelegate familyApiDelegate()
	{
		return new FamilyApiDelegateImpl();
	}
	@Bean
	PeopleApiDelegate peopleApiDelegate()
	{
		return new PeopleApiDelegateImpl();
	}
	

}
