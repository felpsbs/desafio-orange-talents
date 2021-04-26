package br.com.fb.addresscontroller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fb.addresscontroller.domain.City;
import br.com.fb.addresscontroller.domain.State;
import br.com.fb.addresscontroller.repository.CityRepository;
import br.com.fb.addresscontroller.repository.StateRepository;

@SpringBootApplication
public class AddresscontrollerApplication implements CommandLineRunner {

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AddresscontrollerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		State est1 = new State("Minas Gerais", "MG");
		State est2 = new State("São Paulo", "SP");
		
		City c1 = new City("Uberlândia", est1);
		City c2 = new City("São Paulo", est2);
		City c3 = new City("Campinas", est2);
		
		est1.getCities().add(c1);
		est2.getCities().addAll(Arrays.asList(c2,c3));
		
		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
	}

}
