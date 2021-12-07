package com.mintic.tienda;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.tienda.dto.BuscarNumerosDto;
import com.mintic.tienda.dto.ProductoDto;
import com.mintic.tienda.dto.VentaCliente;
import com.mintic.tienda.dto.VentaDto;
import com.mintic.tienda.entities.BuscarNumeros;
import com.mintic.tienda.entities.Cliente;
import com.mintic.tienda.entities.Producto;
import com.mintic.tienda.entities.Venta;
import com.mintic.tienda.servicio.IBuscarNumerosService;
import com.mintic.tienda.servicio.IVentaService;


@RestController
@RequestMapping("/tiendagenerica/v1")
public class ControladorVenta {
	
	@Autowired
	IVentaService iVenteService;
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/reporteVenta")
	public List<VentaCliente>reporteVenta(){
		
		return iVenteService.reporteVenta();
	}
	
	@PostMapping("/enviarSolicitud")
	public BuscarNumeros nuevaSolicitud(@RequestBody BuscarNumerosDto numeroDto) {
		
		System.out.println(numeroDto.getNumeroCliente());
		System.out.println(numeroDto.getNumeroProducto());
		System.out.println(numeroDto.getNumeroUsuario());
		System.out.println(numeroDto.getId());
		return iVenteService.nuevaSolicitudRecursos(numeroDto);

	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/buscarnumeros/{id}")
	public BuscarNumeros buscarNumero(@PathVariable Long id) {
		//return iClienteService.buscarCliente(id);
		return iVenteService.buscarNumerosId(id);
	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/listarNumeros")
	public List<BuscarNumeros> listarNumeros() {

		return iVenteService.getListaNumeros();
	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping("/nuevaVenta")
	public Venta nuevaVenta(@RequestBody VentaDto ventaDto) {
		System.out.println(ventaDto.getId());
		return iVenteService.nuevaVenta(ventaDto);

	}
}
