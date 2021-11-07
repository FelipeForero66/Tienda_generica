package com.mintic.tiendafront;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mintic.tiendafront.client.IClientTienda;
import com.mintic.tiendafront.client.ICliente;
import com.mintic.tiendafront.client.IProducto;
import com.mintic.tiendafront.dto.BuscarNumero;
import com.mintic.tiendafront.dto.BuscarNumerosResponse;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.ProductoCodigo;
import com.mintic.tiendafront.dto.ProductoResponse;
import com.mintic.tiendafront.dto.UsuarioResponse;
import com.mintic.tiendafront.dto.Venta;

@Controller
public class ControladorVenta {
	
	@Autowired
	ICliente icliente;

	
	@Autowired
	IProducto iproducto;
	
	@Autowired
	IClientTienda clienteTienda;
	
	
	
	@GetMapping("/BuscarClienteProducto")
	public String BuscarClienteProducto () {
		return "BuscarClienteProducto";
	}
	
	@PostMapping("/BuscarClienteProducto")
	public String EnviarClienteProducto(Model model, @ModelAttribute BuscarNumero numeroDto) {
		
		
		iproducto.nuevaSolicitud(numeroDto);
		
		System.out.println("resultado al ejecutar el programa por id: " + numeroDto.getNumeroProducto());
		System.out.println("resultado al ejecutar el programa por id: " + numeroDto.getNumeroUsuario());
		
		System.out.println("resultado al ejecutar el programa por id: " + numeroDto.getNumeroCliente());
		
		
		
		return "/BuscarClienteProducto";
	}

	@GetMapping("/realizarVenta")
	public String venta(Model model, @ModelAttribute ProductoCodigo productoDto) {
	
	int productos = iproducto.getNumeros().size();
	Long traerNumeros= (long) productos;	
	BuscarNumerosResponse numeros = iproducto.getnumeroId(traerNumeros);
	
	System.out.println("resultado al ejecutar el programa por id: " + numeros.getNumeroProducto());
	
	String valoresCliente = numeros.getNumeroCliente();
	Long clienteLong = Long.parseLong(valoresCliente);
	Long numeroProducto =  numeros.getNumeroProducto();
	Long Usuario =  numeros.getNumeroUsuario();
	
	Long valores = numeroProducto;
	ProductoResponse producto = iproducto.buscarPorductoId(valores);
	
	Long valorCompra = (long) Math.floor(producto.getPrecioCompra()) ;
	Long valorIva = (long) Math.floor(producto.getIvaCompra()) ;
	Long valorventa = (long) Math.floor(producto.getPrecioVenta()) ;
	

	//ClienteResponse clienteNumero = icliente.BuscarClienteDocVen(numeros);
	ClienteResponse clienteEditar = icliente.buscarCliente(clienteLong);
	UsuarioResponse usuarioEditar = clienteTienda.buscarUsuario(Usuario);
	
	

	//System.out.println("este es el cliente que me esta trayendo" + clienteNumero);
	System.out.println("este es el cliente que me esta trayendo" + clienteEditar.getEmail());
	System.out.println("este es el cliente que me esta trayendo" + clienteEditar.getNombre());
	
	System.out.println("numero de items tabla numeros: " + productos);
	
	System.out.println("resultado al ejecutar el programa por id: " + producto.getNombre());
	
	System.out.println("Valor Redondeado" + valorCompra);
	System.out.println("numero de items tabla numeros: " + valorIva);
	System.out.println("numero de items tabla numeros: " + valorventa);
		
		/*model.addAttribute("productosVentas", iproducto.getProductos());*/
	
		model.addAttribute("valorCompra", valorCompra);
		model.addAttribute("valorIva", valorIva);
		model.addAttribute("valorventa", valorventa);
		model.addAttribute("productosVentas", producto);
		
		model.addAttribute("IdCliente", clienteEditar);
		
		model.addAttribute("IdUsarios", usuarioEditar);
		 
		
		//List<ProductoResponse> clienteventasproductos = iproducto.ProductosVentas(producto)*/
		return "realizarVenta";
	}
	

	@PostMapping("/realizarVenta")
	public String nuevaFactura(Model model, @ModelAttribute Venta ventaDto) {
		
		
		iproducto.nuevaVenta(ventaDto);
		
		System.out.println("resultado al ejecutar el programa por id: " + ventaDto.getIdCliente());
		System.out.println("resultado al ejecutar el programa por id: " + ventaDto.getIdUsuario());
		System.out.println("resultado al ejecutar el programa por id: " + ventaDto.getTotalVenta());
		
			
		return "/BuscarClienteProducto";
}
	

}
