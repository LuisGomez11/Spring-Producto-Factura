package com.factura.app.exceptions;

public class RegistroNoEncontrado extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public RegistroNoEncontrado() {
		super("Registro no encontrado");
	}

}
