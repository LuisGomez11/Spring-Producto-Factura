package com.factura.app.infraestructura.restdto;

public class ProductoRestDto {

	private String codigo;
	private String nombre;
	private Double valor;
	
	public ProductoRestDto() {}

	public ProductoRestDto(String codigo, String nombre, Double valor) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
