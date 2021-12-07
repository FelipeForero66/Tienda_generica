package com.mintic.tienda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.tienda.dto.BuscarNumerosDto;
import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.entities.Cliente;
import com.mintic.tienda.servicio.IClienteService;

@RestController
@RequestMapping("/tiendagenerica/v1")
public class ControladorCliente {

	
	@Autowired
	IClienteService iClienteService;
	
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@DeleteMapping("/cliente/{id}")
	public void eliminarCliente(@PathVariable Long id) {

		iClienteService.borrarCliente(id);
	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/cliente/{id}")
	public Cliente buscarClienteId(@PathVariable Long id) {
		return iClienteService.buscarCliente(id);
	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping("/cliente/documentoNuevoFront")
	public Cliente BuscarClienteFront(@RequestBody ClienteDto clienteDto) {
		return iClienteService.buscarClienteCedula(clienteDto);
	}

	
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/clientes")
	public List<Cliente> listarCliente() {

		return iClienteService.clientes();
	}
	
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping("/cliente")
	public Cliente cliente(@RequestBody ClienteDto clienteDto) {

		return iClienteService.nuevoCliente(clienteDto);
	}

	@PostMapping("/cliente/documento")
	public Cliente buscarDocumento(@RequestBody ClienteDto clienteDto) {

		return iClienteService.buscarClienteCedula(clienteDto);
	}
	

	@PostMapping("/clienteNuevoFront/documento")
	public Cliente clienteNuevoFront(@RequestBody ClienteDto clienteDto) {

		return iClienteService.buscarClienteCedula(clienteDto);
	}
	
	
	
	@PostMapping("/cliente/documento/Venta")
	public Cliente buscarDocumentoVenta(@RequestBody ClienteDto clienteDto) {

		return iClienteService.buscarClienteCedula(clienteDto);
	}
	
	@PostMapping("/clienteVenta")
	public Cliente clienteVentaDocumento(@RequestBody BuscarNumerosDto clienteDto) {
		
		System.out.println("si llegan" + clienteDto.getNumeroCliente());
		
		Cliente numero = iClienteService.buscarClienteCedulaVenta(clienteDto);
		

		return iClienteService.buscarClienteCedulaVenta(clienteDto);
	}

}
