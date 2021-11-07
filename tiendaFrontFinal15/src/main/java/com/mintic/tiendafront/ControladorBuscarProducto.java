package com.mintic.tiendafront;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mintic.tiendafront.client.IClientTienda;
import com.mintic.tiendafront.client.ICliente;
import com.mintic.tiendafront.client.IProducto;
import com.mintic.tiendafront.dto.Cliente;
import com.mintic.tiendafront.dto.ClienteDocumento;
import com.mintic.tiendafront.dto.ClienteDocumentoVenta;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.ClienteResponseVenta;
import com.mintic.tiendafront.dto.Producto;
import com.mintic.tiendafront.dto.ProductoCodigo;
import com.mintic.tiendafront.dto.ProductoResponse;
import com.mintic.tiendafront.dto.ProductoResponseVenta;
import com.mintic.tiendafront.dto.Proveedor;
import com.mintic.tiendafront.dto.VentaResponseDto;

@Controller
public class ControladorBuscarProducto {
	
	@Autowired
	ICliente icliente;

	@Autowired
	IClientTienda clienteTienda;
	
	@Autowired
	IProducto iproducto;
	
	@GetMapping("/ReporteVenta")
	public String ReporteVenta(Model model) {
		
		int total = 0;
		model.addAttribute("reporteVentas", iproducto.getVentas());
		
		//double valor = iproducto.getVentas().get(0).getTotalVenta();
		
		/*for(int i=0; i<iproducto.getVentas().size();i++) {
			
			total= (int) (total + numeros.forEach(reporteVentas.totalVenta));
		}*/
		
		//	System.out.println(valor);
		return "ReporteVenta";
	}

	@GetMapping("/venta")
	public String factura( Model model) {
		
		model.addAttribute("productosVentas", iproducto.getProductos());
		
		//List<ProductoResponse> clienteventasproductos = iproducto.ProductosVentas(producto)
		return "venta";
	}
	

	@PostMapping("/venta")
	public String nuevaFactura(Model model, @ModelAttribute ProductoCodigo productoDto) {
		
		System.out.println("resultado al ejecutar el programa por id: " + productoDto.getId());
		
		ProductoResponse producto = iproducto.buscarPorducto(productoDto);
		
		System.out.println("resultado al ejecutar el programa por id" + producto.getNombre());
		
		model.addAttribute("productosVentas", producto);
			
		return "venta";
}
	
	
	/*@GetMapping("/VentaNueva")
	public String clienteNuevo(Model model) {

		//model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("productoEditar", new ProductoResponse());
		model.addAttribute("venta", new VentaDto());

		return "VentaNueva";
	}*/
	
	/*@GetMapping("/producto/{id}")
	public String actualizarProducto(Model model, @PathVariable(name = "id") Long id) {
		//model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("venta", new VentaDto());
		ProductoResponse productoEditar = iproducto.buscarPorductoId(id);

		model.addAttribute("clienteEditar", productoEditar);
		return "clienteNuevo";
	}*/
	
	
}
