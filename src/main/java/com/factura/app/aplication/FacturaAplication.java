package com.factura.app.aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.factura.app.domain.model.Producto;
import com.factura.app.domain.services.FacturaService;
import com.factura.app.domain.services.ProductoService;
import com.factura.app.exceptions.RegistroNoEncontrado;
import com.factura.app.infraestructura.mapper.FacturaMapper;
import com.factura.app.infraestructura.mapper.ProductoMapper;
import com.factura.app.infraestructura.restdto.FacturaRestDto;
import com.factura.app.infraestructura.restdto.ItemRestDto;
import com.factura.app.infraestructura.restdto.ProductoRestDto;
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
			factura.setCodigo(UUID.randomUUID().toString());
		}

		factura.setValorTotal(calcularFactura(factura));

		facturaService.save(facturaMapper.apiConvertirDtoADominio(factura));
	}

	private Double calcularFactura(FacturaRestDto factura) {
//		List<ProductoRestDto> productos = new ArrayList<ProductoRestDto>();
//		
//		for (ItemRestDto item : factura.getItems()) {
//			System.out.println("Codigo: " + item.getProducto().getCodigo());
//			System.out.println("---------------------");
//			productos.add(loadProducto(new Codigo(item.getProducto().getCodigo())));
//		}

		factura.getItems().stream().forEach(item -> {
			item.setCodigo(UUID.randomUUID().toString());
			item.setProducto(productoMapper.apiConvertirDominioADto(productoService.findById(new Codigo(item.getProducto().getCodigo()))));
			item.setValorTotal(item.getProducto().getValor() * item.getCantidad());
		});

		return factura.getItems().stream().map(i -> i.getValorTotal()).reduce((valor1, valor2) -> valor1 + valor2)
				.get();
	}

	public ProductoRestDto loadProducto(Codigo codigo) {
//		List<Producto> list = new ArrayList<>();
//		list.add(productoService.findById(codigo));
		return productoMapper.apiConvertirDominioADto(productoService.findById(codigo));
	}

	public ProductoRestDto getProducto(String codigo, List<ProductoRestDto> productos) {
		return productos.stream().filter(producto -> producto.getCodigo().matches(codigo)).findAny()
				.orElseThrow(() -> new RegistroNoEncontrado());
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
