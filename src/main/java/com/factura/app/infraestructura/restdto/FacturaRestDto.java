package com.factura.app.infraestructura.restdto;

import java.util.List;

public class FacturaRestDto {

	private String codigo;
	private String cliente;
	private List<ItemRestDto> items;
	private Double valorTotal;
	
	public FacturaRestDto() {}

	public FacturaRestDto(String codigo, String cliente, List<ItemRestDto> items, Double valorTotal) {
		this.codigo = codigo;
		this.cliente = cliente;
		this.items = items;
		this.valorTotal = valorTotal;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<ItemRestDto> getItems() {
		return items;
	}

	public void setItems(List<ItemRestDto> items) {
		this.items = items;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
}
