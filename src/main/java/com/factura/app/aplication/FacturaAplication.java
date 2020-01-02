package com.factura.app.aplication;

import java.util.List;
import java.util.UUID;

import com.factura.app.domain.services.FacturaService;
import com.factura.app.domain.services.ProductoService;
import com.factura.app.infraestructura.mapper.FacturaMapper;
import com.factura.app.infraestructura.mapper.ProductoMapper;
import com.factura.app.infraestructura.restdto.FacturaRestDto;
import com.factura.app.shared.domain.Codigo;

public class FacturaAplication {

	ProductoService productoService;
	ProductoMapper productoMapper;

	FacturaService facturaService;
	FacturaMapper facturaMapper;

	public FacturaAplication(ProductoService productoService, ProductoMapper productoMapper,
			FacturaService facturaService, FacturaMapper facturaMapper) {
		this.productoService = productoService;
		this.productoMapper = productoMapper;
		this.facturaService = facturaService;
		this.facturaMapper = facturaMapper;
	}

	public void save(FacturaRestDto factura) {

		if (factura.getCodigo() == null) {
			// Generar codigo a la factura
			factura.setCodigo(UUID.randomUUID().toString());
		}

		factura.setValorTotal(calcularFactura(factura));

		facturaService.save(facturaMapper.apiConvertirDtoADominio(factura));
	}

	private Double calcularFactura(FacturaRestDto factura) {
		
		factura.getItems().stream().forEach(item -> {
			item.setCodigo(UUID.randomUUID().toString()); // Generar codigo al item de la factura
			// Obtener el producto completo mandando el codigo
			item.setProducto(productoMapper.apiConvertirDominioADto(productoService.findById(new Codigo(item.getProducto().getCodigo()))));
			item.setValorTotal(item.getProducto().getValor() * item.getCantidad()); // Calcular el valor del item
		});

		return factura.getItems().stream().map(i -> i.getValorTotal()).reduce((valor1, valor2) -> valor1 + valor2)
				.get(); // Calcular el valor de la factura sumando el valor de todos los items
	}

	public List<FacturaRestDto> getFacturas() {
		return facturaMapper.apiConvertirDominioParaDto(facturaService.findAll());
	}

	public FacturaRestDto getFactura(Codigo codigo) {
		return facturaMapper.apiConvertirDominioADto(facturaService.findById(codigo));
	}

	public void delete(Codigo codigo) {
		facturaService.delete(codigo);
	}

}
