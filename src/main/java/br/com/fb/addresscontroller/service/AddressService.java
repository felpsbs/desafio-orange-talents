package br.com.fb.addresscontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fb.addresscontroller.domain.Address;
import br.com.fb.addresscontroller.domain.User;
import br.com.fb.addresscontroller.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;
	
	@Autowired
	private UserService userService;
	
	@Transactional
	public Address save(Address address, Long userId) {
		User user = userService.find(userId);
		address.setUser(user);
		address = repository.save(address);
		user.getAdresses().add(address);
		return address;
	}
	
}
