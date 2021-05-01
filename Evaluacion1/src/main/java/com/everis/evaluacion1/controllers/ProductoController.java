package com.everis.evaluacion1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.evaluacion1.models.Producto;
import com.everis.evaluacion1.services.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	ProductoService productoService;

	@RequestMapping("/producto")
	public String productos(Model model) {

		List<Producto> lista = productoService.allProductos();
		model.addAttribute("productos", lista);
		return "producto.jsp";

	}

	@RequestMapping("/submit-producto")
	public String submitProducto(@RequestParam(value = "nombreProducto") String nombreProducto,
			@RequestParam(value = "precio") String precio, Model model) {

		Producto producto = new Producto(nombreProducto, precio);
		boolean insertar = productoService.guardarProducto(producto);

		List<Producto> lista = productoService.allProductos();
		model.addAttribute("productos", lista);

		// Redirige y manda datos
		return "producto.jsp";

	}

	@RequestMapping("/eliminar-producto")
	public String eliminar(@RequestParam(value = "id") Long id, Model model) {

		productoService.deleteById(id);
		List<Producto> lista = productoService.allProductos();
		model.addAttribute("productos", lista);
		return "producto.jsp";

	}

}
