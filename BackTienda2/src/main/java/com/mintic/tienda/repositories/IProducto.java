package com.mintic.tienda.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Cliente;
import com.mintic.tienda.entities.Producto;
import com.mintic.tienda.entities.Usuario;

public interface IProducto  extends CrudRepository<Producto,Long>{

	//Producto findByNumeroProducto(Long id);
	@Query("select p from Producto as p where p.id=:id")
	Producto buscarUProductoPorNumero(@Param("id") Long numero);
	
}
