package com.factura.app.shared.domain;

import com.factura.app.exceptions.NombreNoValidoException;

public class Nombre {
	
	private String value;
	
	public Nombre(String nombre) {
		try {
			this.value = nombre;
			if (!nombre.matches("[A-Z].*")) {
				throw new NombreNoValidoException();

			}
		} catch (NullPointerException e) {
			throw new NombreNoValidoException();
		}
	}
	
	public String getValue() {
		return this.value;
	}
}
