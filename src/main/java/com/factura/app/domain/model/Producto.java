package com.factura.app.domain.model;

import com.factura.app.shared.domain.Codigo;
import com.factura.app.shared.domain.Nombre;
import com.factura.app.shared.domain.Valor;

public class Producto {

	private final Codigo codigo;
	private final Nombre nombre;
	private final Valor valor;
	
	public static Producto of(Codigo codigo, Nombre nombre, Valor valor) {
		return new Producto(codigo, nombre, valor);
	}
	
	private Producto(Codigo codigo, Nombre nombre, Valor valor) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
	}

	public Codigo getCodigo() {
		return codigo;
	}

	public Nombre getNombre() {
		return nombre;
	}

	public Valor getValor() {
		return valor;
	}
	
	
	
}
