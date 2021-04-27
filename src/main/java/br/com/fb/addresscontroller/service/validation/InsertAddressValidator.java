package br.com.fb.addresscontroller.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fb.addresscontroller.client.AddressClient;
import br.com.fb.addresscontroller.client.ViaCEPClient;
import br.com.fb.addresscontroller.client.exception.FeignClientException;
import br.com.fb.addresscontroller.controller.exception.FieldMessage;
import br.com.fb.addresscontroller.dto.AddressDto;

public class InsertAddressValidator implements ConstraintValidator<InsertAddress, AddressDto> {

	@Autowired
	private ViaCEPClient client;

	@Override
	public boolean isValid(AddressDto addressDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		try {
			AddressClient addressClient = client.findAddressByCep(addressDto.getCep());
			addressDto.setBairro(addressClient.getBairro());
			addressDto.setCidade(addressClient.getLocalidade());
			addressDto.setComplemento(addressClient.getComplemento());
			addressDto.setLogradouro(addressClient.getLogradouro());
			addressDto.setUf(addressClient.getUf());
		} catch (FeignClientException e) {
			list.add(new FieldMessage("cep", "CEP inválido"));
		}

		for (FieldMessage fm : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(fm.getMessage()).addPropertyNode(fm.getFieldName())
					.addConstraintViolation();
		}

		return list.isEmpty();
	}

}
