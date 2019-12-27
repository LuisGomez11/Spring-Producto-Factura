package com.factura.app.aplication;

import java.util.List;
import java.util.UUID;

import com.factura.app.domain.services.FacturaService;
import com.factura.app.infraestructura.mapper.FacturaMapper;
import com.factura.app.infraestructura.restdto.FacturaRestDto;
import com.factura.app.infraestructura.restdto.ItemRestDto;
import com.factura.app.shared.domain.Codigo;

public class FacturaAplication {

//	ProductoService productoService;
//	ProductoMapper productoMapper;
	
	FacturaService facturaService;
	FacturaMapper facturaMapper;
	
	public FacturaAplication(FacturaService facturaService, FacturaMapper facturaMapper) {
		this.facturaService = facturaService;
		this.facturaMapper = facturaMapper;
	} 
	
	public void save(FacturaRestDto factura) {
		
		Double valorTotal = 0.0;
		
		if(factura.getCodigo() == null) {
			factura.setCodigo(UUID.randomUUID().toString());
		}
		
		for (ItemRestDto item : factura.getItems()) {
			item.setCodigo(UUID.randomUUID().toString());
			item.setValorTotal(item.getProducto().getValor() * item.getCantidad());
			valorTotal += item.getValorTotal();	
		}

		factura.setValorTotal(valorTotal);
		
		facturaService.save(facturaMapper.apiConvertirDtoADominio(factura));
	} 
	
	
	public List<FacturaRestDto> getFacturas(){
		return facturaMapper.apiConvertirDominioParaDto(facturaService.findAll());
	}
	
	public FacturaRestDto getFactura(Codigo codigo) {
		return facturaMapper.apiConvertirDominioADto(facturaService.findById(codigo));
	}
	
	public void delete(Codigo codigo) {
		facturaService.delete(codigo);
	}
	
}
