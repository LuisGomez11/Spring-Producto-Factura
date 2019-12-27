package com.factura.app.shared.domain;

import com.factura.app.exceptions.ValorNoValidoException;

public class Cantidad {

	private final Integer value;
	
	public Cantidad(Integer cantidad) {
		try {
			this.value = cantidad;
			if (cantidad < 0) {
				throw new ValorNoValidoException();
			}
		} catch (NullPointerException e) {
			throw new ValorNoValidoException();
		}
	}
	
	public Integer getValue() {
		return value;
	}
	
}
