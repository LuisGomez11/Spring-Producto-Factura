package com.factura.app.infraestructura.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factura.app.infraestructura.dto.ProductoDto;

public interface ProductoRepository extends JpaRepository<ProductoDto, String>{

}
