package br.com.fb.addresscontroller.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.fb.addresscontroller.domain.Address;
import br.com.fb.addresscontroller.service.validation.InsertAddress;

@InsertAddress
public class AddressDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String cep;

	@NotNull(message = "Preenchimento obrigatório")
	private String numero;

	private String logradouro;
	private String complemento;
	private String bairro;
	private String estado;
	private String cidade;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Address toAddress() {
		Address address = new Address();
		address.setCep(cep);
		address.setNumero(numero);
		address.setBairro(bairro);
		address.setComplemento(complemento);
		address.setLogradouro(logradouro);
		address.setEstado(estado);
		address.setCidade(cidade);

		return address;
	}

}
