package com.mintic.tienda.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.mintic.tienda.entities.BuscarNumeros;
import com.mintic.tienda.entities.Cliente;

public interface IBuscarNumeros extends CrudRepository<BuscarNumeros,Long> {
	
	

}
