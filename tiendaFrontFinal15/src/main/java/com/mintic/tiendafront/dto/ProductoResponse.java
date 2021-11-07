package com.mintic.tiendafront.dto;

import com.opencsv.bean.CsvBindByName;

public class ProductoResponse {
	
	private Long id;
	
	private Proveedor idProveedor;

	
	private double ivaCompra;

	
	private String nombre;

	
	private double precioCompra;

	
	private double precioVenta;


	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Proveedor getIdProveedor() {
		return idProveedor;
	}


	public void setIdProveedor(Proveedor idProveedor) {
		this.idProveedor = idProveedor;
	}


	public double getIvaCompra() {
		return ivaCompra;
	}


	public void setIvaCompra(double ivaCompra) {
		this.ivaCompra = ivaCompra;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecioCompra() {
		return precioCompra;
	}


	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}


	public double getPrecioVenta() {
		return precioVenta;
	}


	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	

}
