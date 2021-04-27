package br.com.fb.addresscontroller.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import br.com.fb.addresscontroller.domain.User;
import br.com.fb.addresscontroller.service.validation.InsertUser;

@InsertUser
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String name;

	@Email(message = "Email inválido")
	@NotEmpty(message = "Preenchimento obrigatório")
	private String email;

	@CPF(message = "CPF inválido")
	@NotEmpty(message = "Preenchimento obrigatório")
	private String cpf;

	@Past(message = "Data de nascimento deve ser menor que a data atual")
	@NotNull(message = "Preenchimento obrigatório")
	private LocalDate birthDay;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	
	public User toUser() {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setCpf(cpf);
		user.setBirthDay(birthDay);
		
		return user;
	}

}
