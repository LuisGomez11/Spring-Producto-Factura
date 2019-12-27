package com.factura.app.infraestructura.restdto;

public class ItemRestDto {

	private String codigo;
	private ProductoRestDto producto;
	private Integer cantidad;
	private Double valorTotal;
	
	public ItemRestDto() {}

	public ItemRestDto(String codigo, ProductoRestDto producto, Integer cantidad, Double valorTotal) {
		this.codigo = codigo;
		this.producto = producto;
		this.cantidad = cantidad;
		this.valorTotal = valorTotal;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ProductoRestDto getProducto() {
		return producto;
	}

	public void setProducto(ProductoRestDto producto) {
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
