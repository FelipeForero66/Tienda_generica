package com.mintic.tiendafront.dto;

public class VentaResponseDto {
	
private String numeroDocumento;
	
private	String nombre;
	
private double totalVenta;

public String getNumeroDocumento() {
	return numeroDocumento;
}

public void setNumeroDocumento(String numeroDocumento) {
	this.numeroDocumento = numeroDocumento;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public double getTotalVenta() {
	return totalVenta;
}

public void setTotalVenta(double totalVenta) {
	this.totalVenta = totalVenta;
}


}
