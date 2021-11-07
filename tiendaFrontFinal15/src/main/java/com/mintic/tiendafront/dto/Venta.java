package com.mintic.tiendafront.dto;

public class Venta {

	private Long idCliente;

	private Long idUsuario ;

	private Long ivaVenta;

	private Long totalVenta;

	private Long valorVenta;
	
	

	public Long getIvaVenta() {
		return ivaVenta;
	}

	public void setIvaVenta(Long ivaVenta) {
		this.ivaVenta = ivaVenta;
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

	public Long getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(Long valorVenta) {
		this.valorVenta = valorVenta;
	}

	
}
