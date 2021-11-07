package com.mintic.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.ProveedorDto;
import com.mintic.tienda.entities.Proveedor;
import com.mintic.tienda.repositories.IProveedor;

@Service
public class ProveedorIml implements IProveedorService {

	@Autowired
	IProveedor iProveedor;

	@Override
	public List<Proveedor> clientes() {
		return (List<Proveedor>) iProveedor.findAll();
	}

	@Override
	public Proveedor nuevoProveedor(ProveedorDto proveedorDto) {

		Proveedor p = new Proveedor();

		if (proveedorDto.getId() != null) {
			p.setId(proveedorDto.getId());
		}
		
		

		p.setCiudad(proveedorDto.getCiudad());
		p.setDireccion(proveedorDto.getDireccion());
		p.setNit(proveedorDto.getNit());
		p.setNombre(proveedorDto.getNombre());
		p.setTelefono(proveedorDto.getTelefono());

		return iProveedor.save(p);
	}

	@Override
	public Proveedor buscarProveedor(Long id) {

		return iProveedor.findById(id).orElse(null);
	}

	@Override
	public Proveedor buscarProveedorNit(ProveedorDto proveedorDto) {
		return iProveedor.findByNit(proveedorDto.getNit());

	}

	@Override
	public void borrarProveedor(Long id) {
		iProveedor.deleteById(id);
	}

}
