package com.mintic.tienda.dto;

public class BuscarNumerosDto {
	

	private Long id;
	
	private Long numeroProducto;

	private String numeroCliente;
	
	private Long numeroUsuario;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getNumeroUsuario() {
		return numeroUsuario;
	}

	public void setNumeroUsuario(Long numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}
	


	

}
