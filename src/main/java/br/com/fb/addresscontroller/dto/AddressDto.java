package br.com.fb.addresscontroller.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.fb.addresscontroller.domain.Address;
import br.com.fb.addresscontroller.domain.City;
import br.com.fb.addresscontroller.domain.State;

public class AddressDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String logradouro;

	@NotNull(message = "Preenchimento obrigatório")
	private Integer numero;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String complemento;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String bairro;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String cep;

	@NotNull(message = "Preenchimento obrigatório")
	private Long state;

	@NotNull(message = "Preenchimento obrigatório")
	private Long city;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public Long getCity() {
		return city;
	}

	public void setCity(Long city) {
		this.city = city;
	}

	public Address toAddress() {
		Address address = new Address();
		
		State state = new State();
		state.setId(this.state);
		
		City city = new City();
		city.setId(this.city);

		address.setBairro(bairro);
		address.setCep(cep);
		address.setComplemento(complemento);
		address.setLogradouro(logradouro);
		address.setNumero(numero);
		address.setCity(city);
		address.setState(state);

		return address;
	}

}
