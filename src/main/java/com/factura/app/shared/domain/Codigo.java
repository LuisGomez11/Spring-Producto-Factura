package com.factura.app.shared.domain;

import com.factura.app.exceptions.CodigoNoValidoException;

public class Codigo {

	private final String value;

	public Codigo(String value) {
		if(value.length() > 64 || value.length() < 32) {
			throw new CodigoNoValidoException();
		}
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
