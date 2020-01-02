package com.factura.app.infraestructura.repository.adapters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factura.app.domain.model.Producto;
import com.factura.app.domain.services.ProductoService;
import com.factura.app.exceptions.RegistroNoEncontrado;
import com.factura.app.infraestructura.dto.ProductoDto;
import com.factura.app.infraestructura.mapper.ProductoMapper;
import com.factura.app.infraestructura.repository.database.ProductoRepository;
import com.factura.app.shared.domain.Codigo;

@Service
public class ProductoAdapter implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	@Autowired
	ProductoMapper productoMapper;

	@Override
	public List<Producto> findAll() {
		return productoMapper.convertirDtoParaDominio(productoRepository.findAll());
	}

	@Override
	public Producto findById(Codigo codigo) {
		return productoMapper.convertirDtoADominio(productoRepository.findById(codigo.getValue()).get());
	}

	@Override
	public void save(Producto producto) {
		productoRepository.save(productoMapper.convertirDominioADto(producto));

	}

	@Override
	public void delete(Codigo codigo) {
		ProductoDto producto = productoRepository.findById(codigo.getValue())
				.orElseThrow(() -> new RegistroNoEncontrado());
		productoRepository.deleteById(producto.getCodigo());
	}

	@Override
	public List<Producto> findByIds(List<String> codigos) {
//		return productoRepository.findAllById(codigos.stream().map(codigo -> codigo).collect(Collectors.toList()))
//				.stream().map(producto -> productoMapper.convertirDtoADominio(producto)).collect(Collectors.toList());
		return productoMapper.convertirDtoParaDominio(productoRepository.findAllById(codigos));
	}

}
