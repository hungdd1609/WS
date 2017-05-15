package com.ss.mp.common.exception;
public class BadRequestException extends RestException {

	private static final long serialVersionUID = 6582062068219032459L;

	public BadRequestException() {
		super("BAD_REQUEST");
		this.setCode(400);
	}
	
	public BadRequestException(String message) {
		super(message);
		this.setCode(400);
	}

}
