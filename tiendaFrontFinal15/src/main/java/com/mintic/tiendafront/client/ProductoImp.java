package com.mintic.tiendafront.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mintic.tiendafront.dto.BuscarNumero;
import com.mintic.tiendafront.dto.BuscarNumerosResponse;
import com.mintic.tiendafront.dto.CargarNumeros;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.Producto;
import com.mintic.tiendafront.dto.ProductoCodigo;
import com.mintic.tiendafront.dto.ProductoResponse;
import com.mintic.tiendafront.dto.ProductoResponseVenta;
import com.mintic.tiendafront.dto.Proveedor;
import com.mintic.tiendafront.dto.UsuarioResponse;
import com.mintic.tiendafront.dto.Venta;
import com.mintic.tiendafront.dto.VentaResponseDto;

import reactor.core.publisher.Mono;

@Service
public class ProductoImp implements IProducto {
	
	private static final String URL = "http://localhost:8090/tiendagenerica/v1";
	
	@Autowired
	private WebClient.Builder webClient;

	@Override
	public Producto Productos(Producto productoDto) {
		try {

			Producto u = null;
			Mono<Producto> response = webClient.build().post().uri(URL + "/producto")
					.body(Mono.just(productoDto), Producto.class).retrieve().bodyToMono( Producto.class);

			u = response.block();
			
			System.out.println("-***-"+u.getNombre());
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Producto> getProductos() {
		try {
			Mono<List> response = webClient.build().get().uri(URL + "/productos").retrieve().bodyToMono(List.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public Producto ProductosVentas(Producto productoDto) {
		try {

			Producto u = null;
			Mono<Producto> response = webClient.build().post().uri(URL + "/producto")
					.body(Mono.just(productoDto), ProductoResponse.class).retrieve().bodyToMono( Producto.class);

			u = response.block();
			
			System.out.println("-***-"+u.getNombre());
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}

	@Override
	public void borrarProducto(Long id) {
		// TODO Auto-generated method stub
		try {

			Mono<Integer> response = webClient.build().delete().uri(URL + "/producto/" + id).retrieve()
					.bodyToMono(Integer.class);

			 response.block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			
		}
	
	}

	@Override
	public void borrarProductos() {
		try {

			Mono<Integer> response = webClient.build().delete().uri(URL + "/producto/").retrieve()
					.bodyToMono(Integer.class);

			 response.block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			
		}
		
	}

	@Override
	public ProductoResponse buscarPorducto(ProductoCodigo productoDto) {
		try {

			ProductoResponse u = null;
			Mono<ProductoResponse> response = webClient.build().post().uri(URL + "/productos")
					.body(Mono.just(productoDto), ProductoResponse.class).retrieve().bodyToMono(ProductoResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	
	}

	@Override
	public ProductoResponse buscarPorductoId(Long id) {
		try {

			Mono<ProductoResponse> response = webClient.build().get().uri(URL + "/productoId/" + id).retrieve()
					.bodyToMono(ProductoResponse.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<VentaResponseDto> getVentas() {
		try {
			Mono<List> response = webClient.build().get().uri(URL + "/reporteVenta").retrieve().bodyToMono(List.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public BuscarNumerosResponse getnumeroId(Long id) {
		try {

			Mono<BuscarNumerosResponse> response = webClient.build().get().uri(URL + "/buscarnumeros/" + id).retrieve()
					.bodyToMono(BuscarNumerosResponse.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<BuscarNumerosResponse> getNumeros() {
		try {
			Mono<List> response = webClient.build().get().uri(URL + "/listarNumeros").retrieve().bodyToMono(List.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public BuscarNumero nuevaSolicitud(BuscarNumero numeroDto) {
		try {

			Mono<BuscarNumero> response = webClient.build().post().uri(URL + "/enviarSolicitud")
					.body(Mono.just(numeroDto), BuscarNumero.class).retrieve().bodyToMono(BuscarNumero.class);

			return response.block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}

	@Override
	public Venta nuevaVenta(Venta ventaDto) {
		try {
			Mono<Venta> response = webClient.build().post().uri(URL + "/nuevaVenta")
					.body(Mono.just(ventaDto), Venta.class).retrieve().bodyToMono(Venta.class);

			return response.block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}

	

	

}
	
