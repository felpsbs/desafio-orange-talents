package br.com.fb.addresscontroller.controller;

import java.net.URI;

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

import br.com.fb.addresscontroller.domain.User;
import br.com.fb.addresscontroller.dto.UserDto;
import br.com.fb.addresscontroller.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody UserDto userDto) {
		User user = userDto.toUser();
		user = service.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	// Extra
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> find(@PathVariable Long id) {
		User user = service.find(id);
		return ResponseEntity.ok().body(user);
	}
	
}
