package br.com.fb.addresscontroller.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fb.addresscontroller.controller.exception.FieldMessage;
import br.com.fb.addresscontroller.domain.User;
import br.com.fb.addresscontroller.dto.UserDto;
import br.com.fb.addresscontroller.repository.UserRepository;
import br.com.fb.addresscontroller.service.validation.utils.BR;

public class InsertUserValidator implements ConstraintValidator<InsertUser, UserDto> {

	@Autowired
	private UserRepository repository;
	
	@Override
	public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		// Validando CPF único
		User user = repository.findByCpf(userDto.getCpf());
		if(user != null) {
			list.add(new FieldMessage("cpf", "CPF já cadastrado"));
		}
		
		// Validando email único
		user = repository.findByEmail(userDto.getEmail());
		if(user != null) {
			list.add(new FieldMessage("email", "Email já cadastrado"));
		}

		// Validação de cálculo de CPF 
		if(!BR.isValidCPF(userDto.getCpf())) {
			list.add(new FieldMessage("cpf", "CPF inválido"));
		}
		
		for (FieldMessage fm : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(fm.getMessage())
				.addPropertyNode(fm.getFieldName())
				.addConstraintViolation();
		}
		
		return list.isEmpty();
	}

}
