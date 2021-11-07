package com.mintic.tiendafront.dto;

import javax.validation.constraints.NotNull;

public class BuscarNumero {

	private Long id;
	@NotNull(message="El tipo de documento es obligatorio")
	private Long numeroProducto;
	@NotNull(message="El tipo de documento es obligatorio")
	private String numeroCliente;
	@NotNull(message="El tipo de documento es obligatorio")
	private Long numeroUsuario;
	
	

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroUsuario() {
		return numeroUsuario;
	}

	public void setNumeroUsuario(Long numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}



	public Long getNumeroProducto() {
		return numeroProducto;
	}

	public void setNumeroProducto(Long numeroProducto) {
		this.numeroProducto = numeroProducto;
	}

	public String getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	
	
}
