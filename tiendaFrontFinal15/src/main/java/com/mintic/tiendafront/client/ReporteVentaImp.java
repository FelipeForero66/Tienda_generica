package com.mintic.tiendafront.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mintic.tiendafront.dto.Cliente;
import com.mintic.tiendafront.dto.ClienteDocumento;
import com.mintic.tiendafront.dto.ClienteDocumentoVenta;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.ClienteResponseVenta;
import com.mintic.tiendafront.dto.VentaResponseDto;

import reactor.core.publisher.Mono;


public class ReporteVentaImp {
	
	private static final String URL = "http://localhost:8090/tiendagenerica/v1";
	
	@Autowired
	private WebClient.Builder webClient;

	


	
	
}
