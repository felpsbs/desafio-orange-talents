package br.com.fb.addresscontroller.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
