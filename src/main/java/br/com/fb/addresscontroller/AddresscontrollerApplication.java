package br.com.fb.addresscontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AddresscontrollerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddresscontrollerApplication.class, args);
	}

}
