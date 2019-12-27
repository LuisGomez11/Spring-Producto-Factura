package com.factura.app.exceptions;

public class NombreNoValidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NombreNoValidoException() {
		super("Nombre ingresado no valido");
	}

}
