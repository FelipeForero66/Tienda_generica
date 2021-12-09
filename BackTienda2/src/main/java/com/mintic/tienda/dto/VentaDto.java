package com.mintic.tienda.dto;

public class VentaDto {

	private Long id;

	private Long idCliente;

	private Long idUsuario ;

	private Long ivaVenta;

	private Long totalVenta;

	private Long valorVenta;
	
	private Long Sede;
	
	
	public Long getIvaVenta() {
		return ivaVenta;
	}

	public void setIvaVenta(Long ivaVenta) {
		this.ivaVenta = ivaVenta;
	}

	public Long getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(Long valorVenta) {
		this.valorVenta = valorVenta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}


	public Long getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(Long totalVenta) {
		this.totalVenta = totalVenta;
	}

	public Long getSede() {
		return Sede;
	}

	public void setSede(Long sede) {
		Sede = sede;
	}

	

	
	
}
