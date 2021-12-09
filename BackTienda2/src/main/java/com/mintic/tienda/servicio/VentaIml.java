package com.mintic.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.BuscarNumerosDto;
import com.mintic.tienda.dto.VentaCliente;
import com.mintic.tienda.dto.VentaDto;
import com.mintic.tienda.entities.BuscarNumeros;
import com.mintic.tienda.entities.Cliente;
import com.mintic.tienda.entities.Proveedor;
import com.mintic.tienda.entities.Usuario;
import com.mintic.tienda.entities.Venta;
import com.mintic.tienda.repositories.IBuscarNumeros;
import com.mintic.tienda.repositories.IVenta;

@Service
public class VentaIml implements IVentaService{
	
	@Autowired
	IVenta iVenta;
	
	@Autowired
	IBuscarNumeros inumeros;
	
	@Override
	public Venta nuevaVenta(VentaDto ventaDto) {
		Venta numeros = new Venta();

		numeros.setId(ventaDto.getId());
		numeros.setIdCliente(ventaDto.getIdCliente());
		numeros.setIdUsuario(ventaDto.getIdUsuario());
		numeros.setValorVenta(ventaDto.getValorVenta());
		numeros.setIvaVenta(ventaDto.getIvaVenta());
		numeros.setTotalVenta(ventaDto.getTotalVenta());
		numeros.setSede(ventaDto.getSede());
	

		return iVenta.save(numeros);
	}

	@Override
	public List<VentaCliente> reporteVenta() {
		
		List<VentaCliente> l =iVenta.reporte();
		
		return  l;
	}

	@Override
	public BuscarNumeros buscarNumerosId(Long id) {
		BuscarNumeros c = inumeros.findById(id).orElse(null);
		
		return c;
	}

	@Override
	public List<BuscarNumeros> getListaNumeros() {
		return (List<BuscarNumeros>) inumeros.findAll();
	}

	@Override
	public BuscarNumeros nuevaSolicitudRecursos(BuscarNumerosDto numerosDto) {
		BuscarNumeros numeros = new BuscarNumeros();

		numeros.setId(numerosDto.getId());
		numeros.setNumeroCliente(numerosDto.getNumeroCliente());
		numeros.setNumeroProducto(numerosDto.getNumeroProducto());
		numeros.setNumeroUsuario(numerosDto.getNumeroUsuario());

		return inumeros.save(numeros);
		
	}

	

}
