package com.mintic.tienda.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import com.mintic.tienda.entities.BuscarNumeros;
import com.mintic.tienda.entities.Producto;
import com.mintic.tienda.repositories.IBuscarNumeros;


public class BuscarNumerosImp implements IBuscarNumerosService {
	
	@Autowired
	IBuscarNumeros inumeros;

	@Override
	public BuscarNumeros buscarNumerosId(Long id) {
		
		BuscarNumeros c = inumeros.findById(id).orElse(null);
		
		return c;
	}

}
