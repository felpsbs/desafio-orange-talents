package br.com.fb.addresscontroller.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface ViaCEPClient {
	
	@GetMapping("{cep}/json")
    AddressClientDto findAddressByCep(@PathVariable("cep") String cep);

}
