package com.factura.app.exceptions;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {

	private static final Logger LOG = Logger.getLogger(ExceptionHandlers.class.getName());
	
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(Exception.class)
//	public ErrorCode handlerException(Exception e) {
//		ErrorCode ec = new ErrorCode();
//		ec.setCodigo(this.getId());
//		ec.setMensaje("Error no controlado");
//		this.LogError(ec, e);
//		return ec;
//	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CodigoNoValidoException.class)
	public ErrorCode codigoNoValido(CodigoNoValidoException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCodigo(this.getId());
		ec.setMensaje(e.getMessage());
		this.LogError(ec, e);
		return ec;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NombreNoValidoException.class)
	public ErrorCode nombreNoValido(NombreNoValidoException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCodigo(this.getId());
		ec.setMensaje(e.getMessage());
		this.LogError(ec, e);
		return ec;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValorNoValidoException.class)
	public ErrorCode valorNoValido(ValorNoValidoException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCodigo(this.getId());
		ec.setMensaje(e.getMessage());
		this.LogError(ec, e);
		return ec;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(RegistroNoEncontrado.class)
	public ErrorCode registroNoEncontrado(RegistroNoEncontrado e) {
		ErrorCode ec = new ErrorCode();
		ec.setCodigo(this.getId());
		ec.setMensaje(e.getMessage());
		this.LogError(ec, e);
		return ec;
	}
	
	private String getId() {
		return UUID.randomUUID().toString();
	}
	
	public void LogError(ErrorCode errorCode, Exception e) {
		LOG.severe(errorCode.getCodigo());
		LOG.severe(errorCode.getMensaje());
		LOG.severe(e.getMessage());
	}
	
}
