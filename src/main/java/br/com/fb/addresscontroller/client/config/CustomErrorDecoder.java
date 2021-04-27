package br.com.fb.addresscontroller.client.config;

import br.com.fb.addresscontroller.client.exception.FeignClientException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		
		switch (response.status()) {
			case 400:
				return new FeignClientException("CEP inválido");
			default:
				return new Exception("Generic error");
		}
		
	}

}
