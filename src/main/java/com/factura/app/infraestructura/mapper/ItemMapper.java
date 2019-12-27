package com.factura.app.infraestructura.mapper;

import org.springframework.stereotype.Component;

import com.factura.app.domain.model.Item;
import com.factura.app.domain.model.Producto;
import com.factura.app.infraestructura.dto.ItemDto;
import com.factura.app.infraestructura.dto.ProductoDto;
import com.factura.app.infraestructura.restdto.ItemRestDto;
import com.factura.app.infraestructura.restdto.ProductoRestDto;
import com.factura.app.shared.domain.Cantidad;
import com.factura.app.shared.domain.Codigo;
import com.factura.app.shared.domain.Nombre;
import com.factura.app.shared.domain.Valor;
import com.factura.app.shared.infraestructura.MapperApiRest;
import com.factura.app.shared.infraestructura.MapperRepository;

@Component
public class ItemMapper implements MapperRepository<Item, ItemDto>, MapperApiRest<Item, ItemRestDto> {

	@Override
	public Item apiConvertirDtoADominio(ItemRestDto o) {
		return Item.of(new Codigo(o.getCodigo()),
				Producto.of(new Codigo(o.getProducto().getCodigo()), new Nombre(o.getProducto().getNombre()),
						new Valor(o.getProducto().getValor())),
				new Cantidad(o.getCantidad()), new Valor(o.getValorTotal()));
	}

	@Override
	public ItemRestDto apiConvertirDominioADto(Item i) {

		ItemRestDto item = new ItemRestDto(i.getCodigo().getValue(),
				new ProductoRestDto(i.getProducto().getCodigo().getValue(), i.getProducto().getNombre().getValue(),
						i.getProducto().getValor().getValue()),
				i.getCantidad().getValue(), i.getValorTotal().getValue());

		return item;
	}

	@Override
	public Item convertirDtoADominio(ItemDto o) {
		return Item.of(new Codigo(o.getCodigo()),
				Producto.of(new Codigo(o.getProducto().getCodigo()), new Nombre(o.getProducto().getNombre()),
						new Valor(o.getProducto().getValor())),
				new Cantidad(o.getCantidad()), new Valor(o.getValorTotal()));
	}

	@Override
	public ItemDto convertirDominioADto(Item i) {
		ItemDto item = new ItemDto(i.getCodigo().getValue(),
				new ProductoDto(i.getProducto().getCodigo().getValue(), i.getProducto().getNombre().getValue(),
						i.getProducto().getValor().getValue()),
				i.getCantidad().getValue(), i.getValorTotal().getValue());

		return item;
	}

}
