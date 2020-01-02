package com.factura.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.factura.app.aplication.FacturaAplication;
import com.factura.app.domain.services.FacturaService;
import com.factura.app.domain.services.ProductoService;
import com.factura.app.infraestructura.mapper.FacturaMapper;
import com.factura.app.infraestructura.mapper.ProductoMapper;
import com.factura.app.infraestructura.restdto.FacturaRestDto;
import com.factura.app.shared.domain.Codigo;

@RestController
@RequestMapping("/api/factura")
public class FacturaController {

	FacturaAplication facturaAplication;

	public FacturaController(@Autowired FacturaService facturaService, @Autowired FacturaMapper facturaMapper,
			@Autowired ProductoService productoService, @Autowired ProductoMapper productoMapper) {
		this.facturaAplication = new FacturaAplication(productoService, productoMapper, facturaService, facturaMapper);
	}

	@GetMapping
	public List<FacturaRestDto> getFacturas() {
		return facturaAplication.getFacturas();
	}

	@GetMapping("/{codigo}")
	public FacturaRestDto getFactura(@PathVariable Codigo codigo) {
		return facturaAplication.getFactura(codigo);
	}

	@PostMapping
	public void save(@RequestBody FacturaRestDto factura) {
		facturaAplication.save(factura);
	}
	
	@PutMapping
	public void update(@RequestBody FacturaRestDto factura) {
		facturaAplication.save(factura);
	}

	@DeleteMapping("/{codigo}")
	public void delete(@PathVariable Codigo codigo) {
		facturaAplication.delete(codigo);
	}

}
