package com.factura.app.exceptions;

public class ErrorCode {

	private String codigo;
	private String mensaje;
	
	public ErrorCode() {}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
