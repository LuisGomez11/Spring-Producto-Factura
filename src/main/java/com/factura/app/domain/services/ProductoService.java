package com.factura.app.domain.services;

import java.util.List;

import com.factura.app.domain.model.Producto;
import com.factura.app.shared.domain.Codigo;

public interface ProductoService {

	public List<Producto> findAll();

	public Producto findById(Codigo codigo);

	public List<Producto> findByIds(List<String> codigos);

	public void save(Producto producto);

	public void delete(Codigo codigo);

}
