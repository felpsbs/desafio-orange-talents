package br.com.fb.addresscontroller.client.exception;

public class FeignClientException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FeignClientException(String msg) {
		super(msg);
	}

}
