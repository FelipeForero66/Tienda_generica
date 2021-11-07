package com.mintic.tienda.servicio;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mintic.tienda.dto.LoginDto;
import com.mintic.tienda.dto.UsuarioDto;
import com.mintic.tienda.entities.Usuario;

/*
 * Aqui se definen los metodos que se van a utilizar (el contrato)
 * */
public interface IUsuarioService {

	int login(LoginDto usuarioDto);

	List<Usuario> getUsuarios();

	Usuario nuevoUsuario(UsuarioDto usuarioDto);

	Usuario buscarUsuario(Long id);

	int borrarUsuario(Long id);

	Usuario buscarUsuarioPorNumero(UsuarioDto usuarioDto);
	
	ResponseEntity<?> ingresar(LoginDto usuarioDto);
	
	
	Usuario loginUsuario (LoginDto usuarioDto);

}
