package com.factura.app.infraestructura.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factura.app.infraestructura.dto.FacturaDto;

public interface FacturaRepository extends JpaRepository<FacturaDto, String>{

}
