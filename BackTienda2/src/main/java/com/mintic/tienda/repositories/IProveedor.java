package com.mintic.tienda.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mintic.tienda.entities.Proveedor;

public interface IProveedor extends CrudRepository<Proveedor, Long> {

	Proveedor findByNit(String nit);

}
