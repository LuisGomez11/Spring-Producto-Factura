package com.factura.app.infraestructura.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "facturas")
public class FacturaDto extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private String cliente;
	
	@OneToMany(targetEntity = ItemDto.class, cascade = CascadeType.ALL)
	private List<ItemDto> items;
	
	private Double valorTotal;
	
	public FacturaDto() {}

	public FacturaDto(String codigo, String cliente, List<ItemDto> items, Double valorTotal) {
		this.setCodigo(codigo);
		this.cliente = cliente;
		this.items = items;
		this.valorTotal = valorTotal;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<ItemDto> getItems() {
		return items;
	}

	public void setItems(List<ItemDto> items) {
		this.items = items;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	

}
