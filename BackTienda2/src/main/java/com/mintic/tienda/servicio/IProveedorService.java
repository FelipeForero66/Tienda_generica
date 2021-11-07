package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.ProveedorDto;
import com.mintic.tienda.entities.Proveedor;


public interface IProveedorService {
	List<Proveedor> clientes();

	Proveedor nuevoProveedor(ProveedorDto proveedorDto);

	Proveedor buscarProveedor(Long id);
	
	Proveedor buscarProveedorNit(ProveedorDto proveedorDto);
	
	void borrarProveedor(Long id);
}
