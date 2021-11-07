package com.mintic.tiendafront;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mintic.tiendafront.client.IClientTienda;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.LoginDto;
import com.mintic.tiendafront.dto.Producto;
import com.mintic.tiendafront.dto.Usuario;
import com.mintic.tiendafront.dto.UsuarioResponse;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Controller
public class Controlador {

	@Autowired
	IClientTienda clienteTienda;

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("loginDto", new LoginDto());
		return "index";
	}

	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@GetMapping("/buscarUsuario")
	public String buscarUsuario() {
		return "buscarUsuario";
	}
	
	@GetMapping("/ReporteUsuario")
	public String ReporteUsuario(Model model) {
		model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "ReporteUsuario";
	}
	
	
	@PostMapping("/buscarUsuario")/*lo que me llega en del usuario buscado*/
	public String buscarUsuario( Model model, Usuario usuario) {
		//enviamos un usuario que conecta con la interfaz IClientTienda que conecta, que conecta con Clientlmp que conecta con el buscar usuario del back y que nos devuelve un usuario.
		// este usuario que nos regresa los repositorios del back lo guardamos en la variable de clase usuarioEditar.
		//UsuarioResponse usuarioBuscar=;/*este es el metodo que creamos en clientlmp que esta en la interfaz tambien y quie resive un usuario*/
			
			//System.out.println("prueba" usuarioBuscar.getNombre());
			model.addAttribute("prueba", clienteTienda.buscarUsuarioNumero(usuario));
		return "buscarUsuario";

	}

	@PostMapping("/login")
	public String login(Model model, @Valid @ModelAttribute LoginDto loginDto, BindingResult result) {

		if (result.hasErrors()) {
			return "index";
		}
		
		int validLogin = clienteTienda.login(loginDto);
		if (validLogin == 1) {
			return "menu";
		} else {
			model.addAttribute("error", "usuario y clave incorrecta");
			return "index";
		}

	}

	@GetMapping("/usuario")
	public String usuario(Model model) {
		
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarioEditar", new UsuarioResponse());
		model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "usuario";
	}

	@PostMapping("/usuario")
	public String crearUsuario(Model model, @Valid @ModelAttribute Usuario usuario, BindingResult result) {
		
		System.out.println("----"+usuario.getIdTipoDocumento());
		
		model.addAttribute("usuarioEditar", new UsuarioResponse());
		model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("usuarios", clienteTienda.getUsuarios());

		if (result.hasErrors()) {

			return "usuario";
		}

		clienteTienda.nuevoUsuario(usuario);
		model.addAttribute("message", "Registro correcto");
		model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "usuario";
	}

	@GetMapping("/usuario/{id}")
	public String actualizarUsuario(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("usuario", new Usuario());
		UsuarioResponse usuarioEditar = clienteTienda.buscarUsuario(id);
		model.addAttribute("usuarioEditar", usuarioEditar);
		model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("usuarios", clienteTienda.getUsuarios());

		return "usuario";
	}

	@GetMapping("/eliminarusuario/{id}")
	public String eliminarUsuario(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("usuario", new Usuario());
		clienteTienda.borrarUsuario(id);
		model.addAttribute("usuarioEditar", new UsuarioResponse());
		model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("usuarios", clienteTienda.getUsuarios());

		return "usuario";
	}

	
}
