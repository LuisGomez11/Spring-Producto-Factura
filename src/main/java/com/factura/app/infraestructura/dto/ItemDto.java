package com.factura.app.infraestructura.dto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class ItemDto extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@OneToOne(targetEntity = ProductoDto.class)
	private ProductoDto producto;
	
	private Integer cantidad;
	private Double valorTotal;
	
	public ItemDto() {}

	public ItemDto(String codigo, ProductoDto producto, Integer cantidad, Double valorTotal) {
		this.setCodigo(codigo);
		this.producto = producto;
		this.cantidad = cantidad;
		this.valorTotal = valorTotal;
	}

	public ProductoDto getProducto() {
		return producto;
	}

	public void setProducto(ProductoDto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	

}
