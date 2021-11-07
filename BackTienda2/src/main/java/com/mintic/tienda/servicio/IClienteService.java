package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.BuscarNumerosDto;
import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.entities.Cliente;

public interface IClienteService {
	List<Cliente> clientes();

	Cliente nuevoCliente(ClienteDto clienteDto);

	Cliente buscarCliente(Long id);

	void borrarCliente(Long id);
	
	Cliente buscarClienteCedula(ClienteDto clienteDto);

	Cliente buscarClienteCedulaVenta(BuscarNumerosDto clienteDto);
}
