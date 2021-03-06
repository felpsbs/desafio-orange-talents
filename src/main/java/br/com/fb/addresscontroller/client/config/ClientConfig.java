package br.com.fb.addresscontroller.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.ErrorDecoder;

@Configuration
public class ClientConfig {

	@Bean
	public ErrorDecoder errorDecoder() {
		return new CustomErrorDecoder();
	}
	
}
