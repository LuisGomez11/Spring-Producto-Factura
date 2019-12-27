package com.factura.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.factura.app.aplication.ProductoAplication;
import com.factura.app.domain.services.ProductoService;
import com.factura.app.infraestructura.mapper.ProductoMapper;
import com.factura.app.infraestructura.restdto.ProductoRestDto;
import com.factura.app.shared.domain.Codigo;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/producto")
public class ProductoController {

	ProductoAplication productoAplication;
	
	public ProductoController(@Autowired ProductoService productoService, @Autowired ProductoMapper productoMapper) {
		this.productoAplication = new ProductoAplication(productoService, productoMapper);
	}
	
	@GetMapping
	public List<ProductoRestDto> getProductos(){
		return productoAplication.getProductos();
	}
	
	@GetMapping("/{codigo}")
	public ProductoRestDto getProducto(@PathVariable Codigo codigo) {
		return productoAplication.getProducto(codigo);
	}
	
	@PostMapping
	public void save(@RequestBody ProductoRestDto producto) {
		productoAplication.save(producto);
	}
	
	@PutMapping
	public void update(@RequestBody ProductoRestDto producto) {
		productoAplication.update(producto);
	}
	
	@DeleteMapping("/{codigo}")
	public void delete(@PathVariable Codigo codigo) {
		productoAplication.delete(codigo);
	}
	
}
