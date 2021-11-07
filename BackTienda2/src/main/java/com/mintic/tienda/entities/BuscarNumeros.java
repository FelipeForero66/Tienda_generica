package com.mintic.tienda.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = BuscarNumeros.TABLE_NAME)
public class BuscarNumeros {
	
	public static final String TABLE_NAME = "buscarnumeros";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long numeroProducto;

	private String numeroCliente;
	
	private Long numeroUsuario;
	

	public Long getNumeroUsuario() {
		return numeroUsuario;
	}

	public void setNumeroUsuario(Long numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}

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
	
	
}
