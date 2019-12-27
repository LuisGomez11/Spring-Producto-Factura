package com.factura.app.aplication;

import java.util.List;
import java.util.UUID;

import com.factura.app.domain.services.ProductoService;
import com.factura.app.infraestructura.mapper.ProductoMapper;
import com.factura.app.infraestructura.restdto.ProductoRestDto;
import com.factura.app.shared.domain.Codigo;

public class ProductoAplication {

	ProductoService productoService;
	ProductoMapper productoMapper;

	public ProductoAplication(ProductoService productoService, ProductoMapper productoMapper) {
		this.productoService = productoService;
		this.productoMapper = productoMapper;
	}
	
	public void save(ProductoRestDto producto) {
		if(producto.getCodigo() == null) {
			producto.setCodigo(UUID.randomUUID().toString());
		}
		productoService.save(productoMapper.apiConvertirDtoADominio(producto));
	}
	
	public List<ProductoRestDto> getProductos(){
		return productoMapper.apiConvertirDominioParaDto(productoService.findAll());
	}
	
	public ProductoRestDto getProducto(Codigo codigo){
		return productoMapper.apiConvertirDominioADto(productoService.findById(codigo));
	}
	
	public void delete(Codigo codigo) {
		productoService.delete(codigo);
	}
	
	public void update(ProductoRestDto producto) {
		productoService.save(productoMapper.apiConvertirDtoADominio(producto));
	}
	
}
