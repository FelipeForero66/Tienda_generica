package com.mintic.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.ProductoDto;
import com.mintic.tienda.entities.Cliente;
import com.mintic.tienda.entities.Producto;
import com.mintic.tienda.entities.Proveedor;
import com.mintic.tienda.repositories.IProducto;

@Service
public class ProductoIml implements IProductoService {

	@Autowired
	IProducto iProducto;

	@Override
	public List<Producto> producto() {

		return (List<Producto>) iProducto.findAll();
	}

	@Override
	public Producto nuevoProducto(ProductoDto productoDto) {

		Producto p = new Producto();
		Proveedor pr = new Proveedor();

		pr.setId(productoDto.getIdProveedor());

		if (productoDto.getId() != null) {
			p.setId(productoDto.getId());
		}
		
		p.setIdProveedor(pr);
		p.setIvaCompra(productoDto.getIvaCompra());
		p.setNombre(productoDto.getNombre());
		p.setPrecioCompra(productoDto.getPrecioCompra());
		p.setPrecioVenta(productoDto.getPrecioVenta());

		return iProducto.save(p);
		
		

	}

	@Override
	public Producto buscarProducto(ProductoDto productoDto) {
		return iProducto.findById(productoDto.getId()).orElse(null);

	}

	@Override
	public void eliminarProductoId(Long id) {
		iProducto.deleteById(id);

	}

	@Override
	public void elminarProductos() {
		iProducto.deleteAll();

	}

	@Override
	public Producto buscarProductoNumero(ProductoDto productoDto) {
		// TODO Auto-generated method stub
		return iProducto.buscarUProductoPorNumero(productoDto.getId());
	}


	@Override
	public Producto buscarProductoId(Long id) {
		Producto c = iProducto.findById(id).orElse(null);
		return c;
		
	}

}
