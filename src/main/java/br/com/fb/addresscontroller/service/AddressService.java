package br.com.fb.addresscontroller.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fb.addresscontroller.domain.Address;
import br.com.fb.addresscontroller.domain.User;
import br.com.fb.addresscontroller.dto.AddressDto;
import br.com.fb.addresscontroller.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	public Address save(Address address, Long userId) {
		User user = userService.find(userId);
		address.setUser(user);
		address = repository.save(address);
		return address;
	}

	public List<Address> find(Long userId) {
		User user = userService.find(userId);
		return repository.findByUser(user);
	}
	
	public Address fromDto(AddressDto dto) {
		return modelMapper.map(dto, Address.class);
	}

}
