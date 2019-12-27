package com.factura.app.infraestructura.mapper;

import org.springframework.stereotype.Component;

import com.factura.app.domain.model.Producto;
import com.factura.app.infraestructura.dto.ProductoDto;
import com.factura.app.infraestructura.restdto.ProductoRestDto;
import com.factura.app.shared.domain.Codigo;
import com.factura.app.shared.domain.Nombre;
import com.factura.app.shared.domain.Valor;
import com.factura.app.shared.infraestructura.MapperApiRest;
import com.factura.app.shared.infraestructura.MapperRepository;

@Component
public class ProductoMapper implements MapperRepository<Producto, ProductoDto>, MapperApiRest<Producto, ProductoRestDto>{

	@Override
	public Producto apiConvertirDtoADominio(ProductoRestDto o) {
		return Producto.of(new Codigo(o.getCodigo()), new Nombre(o.getNombre()), new Valor(o.getValor()));
	}

	@Override
	public ProductoRestDto apiConvertirDominioADto(Producto i) {
		ProductoRestDto producto = new ProductoRestDto();
		
		producto.setCodigo(i.getCodigo().getValue());
		producto.setNombre(i.getNombre().getValue());
		producto.setValor(i.getValor().getValue());
		
		return producto;
	}

	@Override
	public Producto convertirDtoADominio(ProductoDto o) {
		return Producto.of(new Codigo(o.getCodigo()), new Nombre(o.getNombre()), new Valor(o.getValor()));
	}

	@Override
	public ProductoDto convertirDominioADto(Producto i) {
		ProductoDto producto = new ProductoDto(i.getCodigo().getValue(), i.getNombre().getValue(), i.getValor().getValue());
		return producto;
	}

}
