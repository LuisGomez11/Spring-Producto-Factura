package com.factura.app.infraestructura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.factura.app.domain.model.Factura;
import com.factura.app.infraestructura.dto.FacturaDto;
import com.factura.app.infraestructura.restdto.FacturaRestDto;
import com.factura.app.shared.domain.Codigo;
import com.factura.app.shared.domain.Nombre;
import com.factura.app.shared.domain.Valor;
import com.factura.app.shared.infraestructura.MapperApiRest;
import com.factura.app.shared.infraestructura.MapperRepository;

@Component
public class FacturaMapper implements MapperRepository<Factura, FacturaDto>, MapperApiRest<Factura, FacturaRestDto>{

	@Autowired
	ItemMapper itemMapper;
	
	@Override
	public Factura apiConvertirDtoADominio(FacturaRestDto o) {
		return Factura.of(new Codigo(o.getCodigo()), new Nombre(o.getCliente()),
				itemMapper.apiConvertirDtoParaDominio(o.getItems()), new Valor(o.getValorTotal()));
	}

	@Override
	public FacturaRestDto apiConvertirDominioADto(Factura i) {
		FacturaRestDto factura = new FacturaRestDto(i.getCodigo().getValue(),
				i.getCliente().getValue(),
				itemMapper.apiConvertirDominioParaDto(i.getItems()),
				i.getValorTotal().getValue());
		return factura;
	}

	@Override
	public Factura convertirDtoADominio(FacturaDto o) {
		return Factura.of(new Codigo(o.getCodigo()), new Nombre(o.getCliente()),
				itemMapper.convertirDtoParaDominio(o.getItems()), new Valor(o.getValorTotal()));
	}

	@Override
	public FacturaDto convertirDominioADto(Factura i) {
		FacturaDto factura = new FacturaDto(i.getCodigo().getValue(),
				i.getCliente().getValue(),
				itemMapper.convertirDominioParaDto(i.getItems()),
				i.getValorTotal().getValue());
		return factura;
	}

}
