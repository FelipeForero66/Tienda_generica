package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.BuscarNumerosDto;
import com.mintic.tienda.dto.ProveedorDto;
import com.mintic.tienda.dto.VentaCliente;
import com.mintic.tienda.dto.VentaDto;
import com.mintic.tienda.entities.BuscarNumeros;
import com.mintic.tienda.entities.Cliente;
import com.mintic.tienda.entities.Proveedor;
import com.mintic.tienda.entities.Venta;

public interface IVentaService {

	Venta nuevaVenta(VentaDto ventaDto);
	List<VentaCliente>reporteVenta();
	
	BuscarNumeros buscarNumerosId(Long id);
	
	List<BuscarNumeros> getListaNumeros();
	
	BuscarNumeros nuevaSolicitudRecursos(BuscarNumerosDto numerosDto);
	
	
}
