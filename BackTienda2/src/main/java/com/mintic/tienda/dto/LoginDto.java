package com.mintic.tienda.dto;

public class LoginDto {
	
	private String nombreUsuario;
	
	private String password;
	
	private Long Sede;

	

	

	public Long getSede() {
		return Sede;
	}

	public void setSede(Long sede) {
		Sede = sede;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}	
