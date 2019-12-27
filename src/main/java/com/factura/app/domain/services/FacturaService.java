package com.factura.app.domain.services;

import java.util.List;

import com.factura.app.domain.model.Factura;
import com.factura.app.shared.domain.Codigo;

public interface FacturaService {

	public List<Factura> findAll();
	public Factura findById(Codigo codigo);
	public void save(Factura factura);
	public void delete(Codigo codigo);
	
}
