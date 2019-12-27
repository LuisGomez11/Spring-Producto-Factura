package com.factura.app.exceptions;

public class CodigoNoValidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CodigoNoValidoException() {
		super("Codigo no valido");
	}

}
