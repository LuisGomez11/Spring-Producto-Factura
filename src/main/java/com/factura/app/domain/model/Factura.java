package com.factura.app.domain.model;

import java.util.List;

import com.factura.app.shared.domain.Codigo;
import com.factura.app.shared.domain.Nombre;
import com.factura.app.shared.domain.Valor;

public class Factura {

	private final Codigo codigo;
	private final Nombre cliente;
	private final List<Item> items;
	private final Valor valorTotal;
	
	public static Factura of(Codigo codigo, Nombre cliente, List<Item> items, Valor valorTotal) {
		return new Factura(codigo, cliente, items, valorTotal);
	}
	
	private Factura(Codigo codigo, Nombre cliente, List<Item> items, Valor valorTotal) {
		this.codigo = codigo;
		this.cliente = cliente;
		this.items = items;
		this.valorTotal = valorTotal;
	}


	public Codigo getCodigo() {
		return codigo;
	}


	public Nombre getCliente() {
		return cliente;
	}


	public List<Item> getItems() {
		return items;
	}


	public Valor getValorTotal() {
		return valorTotal;
	}
	
	
	
}
