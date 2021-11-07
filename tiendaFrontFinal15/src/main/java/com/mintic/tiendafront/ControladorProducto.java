package com.mintic.tiendafront;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
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
import com.mintic.tiendafront.client.IProducto;
import com.mintic.tiendafront.dto.Cliente;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.Producto;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Controller
public class ControladorProducto {
	
	
	@Autowired
	IProducto iproducto;

	
	@GetMapping("/producto")
	public String productos(Model model) {
		
		model.addAttribute("productos", iproducto.getProductos());
		
		return "producto";
	}
	
	//el multipartFile es un archivo file que es de multiple file. en el front web esta el enctype="multipart/form-data">que es para indicar que se enviara un arcivo desde el formulario.
	//

	@PostMapping("/producto")
	public String productos(@RequestParam("file") MultipartFile file, Model model) {
		
		

		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a CSV file to upload.");
			model.addAttribute("status", false);
		} else {

			try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

				CsvToBean<Producto> csvToBean = new CsvToBeanBuilder(reader).withType(Producto.class)
						.withIgnoreLeadingWhiteSpace(true).build();

				List<Producto> producto = csvToBean.parse();
				Producto c = new Producto();
				for (int i = 0; i < producto.size(); i++) {
					
					String nombre = producto.get(i).getNombre();
					double precioCompra = producto.get(i).getPrecioCompra();
					Long id = (long) producto.get(i).getIdProveedor();
					double iva = producto.get(i).getIvaCompra();
					double precioVenta = producto.get(i).getPrecioVenta();
					
					c.setIdProveedor(id);
					c.setIvaCompra(iva);
					c.setPrecioCompra(precioCompra);
					c.setNombre(nombre);
					c.setPrecioVenta(precioVenta);
					
					iproducto.Productos(c);
					
				}

				model.addAttribute("producto", producto);
				model.addAttribute("status", true);

			} catch (Exception ex) {
				model.addAttribute("message", "An error occurred while processing the CSV file.");
				model.addAttribute("status", false);
			}
		}
		
		model.addAttribute("productos", iproducto.getProductos());

		return ("producto");
	}
	
	@GetMapping("/eliminarProducto/{id}")
	public String eliminarProducto(Model model, @PathVariable(name = "id") Long id) {
		iproducto.borrarProducto(id);
		model.addAttribute("productos", iproducto.getProductos());
		return "/producto";
	}
	
	
	@GetMapping("/eliminarProducto")
	public String eliminarProductos(Model model) {
		//iproducto.borrarProducto(id);
		iproducto.borrarProductos();
		model.addAttribute("productos", iproducto.getProductos());
		return "/producto";
	}
	

}
