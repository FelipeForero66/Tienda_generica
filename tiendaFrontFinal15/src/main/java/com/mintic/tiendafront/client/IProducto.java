package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.BuscarNumero;
import com.mintic.tiendafront.dto.BuscarNumerosResponse;
import com.mintic.tiendafront.dto.CargarNumeros;
import com.mintic.tiendafront.dto.Cliente;
import com.mintic.tiendafront.dto.ClienteDocumento;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.Producto;
import com.mintic.tiendafront.dto.ProductoCodigo;
import com.mintic.tiendafront.dto.ProductoResponse;
import com.mintic.tiendafront.dto.ProductoResponseVenta;
import com.mintic.tiendafront.dto.Usuario;
import com.mintic.tiendafront.dto.UsuarioResponse;
import com.mintic.tiendafront.dto.Venta;
import com.mintic.tiendafront.dto.VentaResponseDto;

public interface IProducto {
	
	public Producto Productos(Producto productoDto);
	
	public Producto ProductosVentas(Producto productoDto);
	
	public ProductoResponse buscarPorductoId(Long id);
	
	public void borrarProducto(Long id);
	
	public void borrarProductos();
	
	public ProductoResponse buscarPorducto(ProductoCodigo productoDto);
	
	public List<Producto> getProductos();
	
	public List<VentaResponseDto> getVentas();
	
	public BuscarNumerosResponse getnumeroId (Long id);
	
	public List<BuscarNumerosResponse> getNumeros();
	
	public BuscarNumero nuevaSolicitud(BuscarNumero numeroDto);
	
	public Venta nuevaVenta(Venta ventaDto);

}
