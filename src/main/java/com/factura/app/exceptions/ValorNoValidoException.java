package com.factura.app.exceptions;

public class ValorNoValidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ValorNoValidoException() {
		super("Valor ingresado no valido");
	}

}
