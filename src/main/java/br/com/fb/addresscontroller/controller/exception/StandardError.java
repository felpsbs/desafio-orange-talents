package br.com.fb.addresscontroller.controller.exception;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long timeStamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	public StandardError(Long timeStamp, Integer status, String error, String message, String path) {
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

}
