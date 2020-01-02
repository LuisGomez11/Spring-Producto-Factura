package com.factura.app.shared.domain;

import com.factura.app.exceptions.CodigoNoValidoException;

public class Codigo {

	private final String value;

	public Codigo(String codigo) {
		this.value = codigo;
		try {
			if (value.length() > 64 || value.length() < 32) {
				throw new CodigoNoValidoException();
			}
		} catch (NullPointerException e) {
			throw new CodigoNoValidoException();
		}

	}

	public String getValue() {
		return value;
	}

}
