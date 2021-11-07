package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.BuscarNumerosResponse;
import com.mintic.tiendafront.dto.Cliente;
import com.mintic.tiendafront.dto.ClienteDocumento;
import com.mintic.tiendafront.dto.ClienteDocumentoVenta;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.ClienteResponseVenta;
import com.mintic.tiendafront.dto.Venta;

public interface ICliente {
	public List<ClienteResponse> getCliente();

	public ClienteResponse nuevoCliente(Cliente clienteDto);

	public ClienteResponse buscarCliente(Long id);

	public ClienteResponse buscarClienteDocumento(ClienteDocumento clienteDto);
	
	public ClienteResponse buscarClienteDocumentoVenta(ClienteDocumento clienteDto);

	public void borrarCliente(Long id);

	public ClienteResponseVenta buscarClienteDocumentoVenta(ClienteDocumentoVenta clienteDto);
	
	public ClienteResponse BuscarClienteDocVen(BuscarNumerosResponse numeroCliente);
}
