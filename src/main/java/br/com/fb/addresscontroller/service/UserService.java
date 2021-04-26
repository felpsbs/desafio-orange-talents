package br.com.fb.addresscontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fb.addresscontroller.domain.User;
import br.com.fb.addresscontroller.repository.UserRepository;
import br.com.fb.addresscontroller.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional
	public User save(User user) {
		return repository.save(user);
	}
	
	public User find(Long id) {
		User user = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
		return user;
	}

}
