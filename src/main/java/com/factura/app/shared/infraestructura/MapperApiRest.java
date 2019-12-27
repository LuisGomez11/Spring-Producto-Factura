package com.factura.app.shared.infraestructura;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperApiRest <I,O>{

	public I apiConvertirDtoADominio(O o);
	
	public O apiConvertirDominioADto (I i);
	
	public default List<I> apiConvertirDtoParaDominio(List<O> instancias) {
		return instancias.stream().map(i -> apiConvertirDtoADominio(i)).collect(Collectors.toList());
	}
	
	public default List<O> apiConvertirDominioParaDto(List<I> instancias) {
		return instancias.stream().map(o -> apiConvertirDominioADto(o)).collect(Collectors.toList());
	}
}
