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

import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.dto.ProductoDto;
import com.mintic.tienda.entities.Cliente;
import com.mintic.tienda.entities.Producto;
import com.mintic.tienda.servicio.IProductoService;

@RestController
@RequestMapping("/tiendagenerica/v1")
public class ControladorProducto {

	@Autowired
	IProductoService iProductoService;

	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/productos")
	public List<Producto> productos() {
		return iProductoService.producto();
	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/productoId/{id}")
	public Producto buscarProductoId(@PathVariable Long id) {
		return iProductoService.buscarProductoId(id);
	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping("/productos")
	public Producto productoId(@RequestBody ProductoDto productoDto) {
		return iProductoService.buscarProducto(productoDto);
	}

	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping("/producto")
	public Producto producto(@RequestBody ProductoDto productoDto) {
		return iProductoService.nuevoProducto(productoDto);

	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@DeleteMapping("/producto/{id}")
	public void eliminarProducto(@PathVariable Long id) {

		iProductoService.eliminarProductoId(id);
	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@DeleteMapping("/productos")
	public void eliminarProductos() {

		iProductoService.elminarProductos();
	}
	
	@PostMapping("/busacarProducto")
	public Producto buscarDocumento(@RequestBody ProductoDto productoDto) {
		
		
		return iProductoService.buscarProductoNumero(productoDto);
	}

}
