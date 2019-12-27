package com.factura.app.infraestructura.repository.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factura.app.domain.model.Factura;
import com.factura.app.domain.services.FacturaService;
import com.factura.app.exceptions.RegistroNoEncontrado;
import com.factura.app.infraestructura.dto.FacturaDto;
import com.factura.app.infraestructura.mapper.FacturaMapper;
import com.factura.app.infraestructura.repository.database.FacturaRepository;
import com.factura.app.shared.domain.Codigo;

@Service
public class FacturaAdapter implements FacturaService{

	@Autowired
	FacturaRepository facturaRepository;
	
	@Autowired
	FacturaMapper facturaMapper;
	
	@Override
	public List<Factura> findAll() {
		return facturaMapper.convertirDtoParaDominio(facturaRepository.findAll());
	}

	@Override
	public Factura findById(Codigo codigo) {
		return facturaMapper.convertirDtoADominio(facturaRepository.findById(codigo.getValue()).get());
	}

	@Override
	public void save(Factura factura) {
		facturaRepository.save(facturaMapper.convertirDominioADto(factura));
	}

	@Override
	public void delete(Codigo codigo) {
		FacturaDto factura = facturaRepository.findById(codigo.getValue()).orElseThrow(() -> new RegistroNoEncontrado());
		facturaRepository.deleteById(factura.getCodigo());
	}

}
