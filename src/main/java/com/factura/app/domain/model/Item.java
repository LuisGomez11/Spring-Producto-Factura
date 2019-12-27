package com.factura.app.domain.model;

import com.factura.app.shared.domain.Cantidad;
import com.factura.app.shared.domain.Codigo;
import com.factura.app.shared.domain.Valor;

public class Item {

	private final Codigo codigo;
	private final Producto producto;
	private final Cantidad cantidad;
	private final Valor valorTotal;
	
	public static Item of(Codigo codigo, Producto producto, Cantidad cantidad, Valor valorTotal) {
		return new Item(codigo, producto, cantidad, valorTotal);
	}
	
	private Item(Codigo codigo, Producto producto, Cantidad cantidad, Valor valorTotal) {
		this.codigo = codigo;
		this.producto = producto;
		this.cantidad = cantidad;
		this.valorTotal = valorTotal;
	}

	public Codigo getCodigo() {
		return codigo;
	}

	public Producto getProducto() {
		return producto;
	}

	public Cantidad getCantidad() {
		return cantidad;
	}

	public Valor getValorTotal() {
		return valorTotal;
	}
	
	
	
}
