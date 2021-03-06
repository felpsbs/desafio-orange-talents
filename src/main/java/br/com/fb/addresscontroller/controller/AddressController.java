package br.com.fb.addresscontroller.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fb.addresscontroller.domain.Address;
import br.com.fb.addresscontroller.dto.AddressDto;
import br.com.fb.addresscontroller.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService service;

	@PostMapping(value = "/{userId}")
	public ResponseEntity<Address> save(@Valid @RequestBody AddressDto addressDto, @PathVariable Long userId) {
		Address address = service.fromDto(addressDto);
		address = service.save(address, userId);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(address.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<List<Address>> find(@PathVariable Long userId) {
		List<Address> addresses = service.find(userId);
		return ResponseEntity.ok().body(addresses);
	}
	
}
