package com.factura.app.shared.domain;

import com.factura.app.exceptions.ValorNoValidoException;

public class Valor {

	private final Double value;
	
	public Valor(Double valor) {
		try {
			this.value = valor;
			if (valor <= 0) {
				throw new ValorNoValidoException();
			}
		} catch (NullPointerException e) {
			throw new ValorNoValidoException();
		}
	}
	
	public Double getValue() {
		return value;
	}
	
}
