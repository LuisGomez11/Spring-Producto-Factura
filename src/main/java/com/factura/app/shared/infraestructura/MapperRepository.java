package com.factura.app.shared.infraestructura;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperRepository <I,O>{

	public I convertirDtoADominio(O o);
	
	public O convertirDominioADto (I i);
	
	public default List<I> convertirDtoParaDominio(List<O> instancias) {
		return instancias.stream().map(i -> convertirDtoADominio(i)).collect(Collectors.toList());
	}
	
	public default List<O> convertirDominioParaDto(List<I> instancias) {
		return instancias.stream().map(o -> convertirDominioADto(o)).collect(Collectors.toList());
	}
}
