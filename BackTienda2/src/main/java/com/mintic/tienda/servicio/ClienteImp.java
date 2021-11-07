package com.mintic.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.BuscarNumerosDto;
import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.entities.Cliente;
import com.mintic.tienda.entities.TipoDocumento;
import com.mintic.tienda.repositories.ICliente;
@Service
public class ClienteImp implements IClienteService {

	@Autowired
	ICliente iCliente;

	@Override
	public List<Cliente> clientes() {

		return (List<Cliente>) iCliente.findAll();
	}

	@Override
	public Cliente nuevoCliente(ClienteDto clienteDto) {
		Cliente c = new Cliente();

		if (clienteDto.getId() != null) {
			c.setId(clienteDto.getId());
		}

		TipoDocumento tipo = new TipoDocumento();
		tipo.setId(clienteDto.getIdTipoDocumento());

		c.setDireccion(clienteDto.getDireccion());
		c.setEmail(clienteDto.getEmail());
		c.setIdTipoDocumento(tipo);
		c.setNombre(clienteDto.getNombre());
		c.setNumeroDocumento(clienteDto.getNumeroDocumento());
		c.setTelefono(clienteDto.getTelefono());

		return iCliente.save(c);
	}

	@Override
	public Cliente buscarCliente(Long id) {
		Cliente c = iCliente.findById(id).orElse(null);
		return c;
	}

	@Override
	public void borrarCliente(Long id) {
		// TODO Auto-generated method stub
		iCliente.deleteById(id);
	}

	@Override
	public Cliente buscarClienteCedula(ClienteDto clienteDto) {
		Cliente c = iCliente.findByNumeroDocumento(clienteDto.getNumeroDocumento());
		return c;
		
	}

	@Override
	public Cliente buscarClienteCedulaVenta(BuscarNumerosDto clienteDto) {
		
		System.out.println("si llegan fase 2 " + clienteDto.getNumeroCliente());
		Cliente d = iCliente.findByNumeroDocumento(clienteDto.getNumeroCliente());
		System.out.println("si llegan fase 3 " + d.getNumeroDocumento());
		return d;
	}

}
