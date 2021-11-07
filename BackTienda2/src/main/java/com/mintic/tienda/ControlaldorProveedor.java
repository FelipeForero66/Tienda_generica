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

import com.mintic.tienda.dto.ProveedorDto;
import com.mintic.tienda.entities.Proveedor;
import com.mintic.tienda.servicio.IProveedorService;

@RestController
@RequestMapping("/tiendagenerica/v1")
public class ControlaldorProveedor {

	@Autowired
	IProveedorService iProveedorService;

	@DeleteMapping("/proveedor/{id}")
	public void eliminarCliente(@PathVariable Long id) {

		iProveedorService.borrarProveedor(id);
	}

	@GetMapping("/proveedor/{id}")
	public Proveedor buscarProveedorId(@PathVariable Long id) {
		return iProveedorService.buscarProveedor(id);
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/proveedor")
	public List<Proveedor> listarProveedor() {

		return iProveedorService.clientes();
	}

	@PostMapping("/proveedor")
	public Proveedor proveedor(@RequestBody ProveedorDto proveedorDto) {

		return iProveedorService.nuevoProveedor(proveedorDto);
	}

	@PostMapping("/proveedor/nit")
	public Proveedor buscarNit(@RequestBody ProveedorDto proveedorDto) {

		return iProveedorService.buscarProveedorNit(proveedorDto);
	}

}
