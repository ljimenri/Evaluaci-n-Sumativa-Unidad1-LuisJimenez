package com.everis.evaluacion1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.evaluacion1.models.Producto;
import com.everis.evaluacion1.models.Usuario;
import com.everis.evaluacion1.models.Venta;
import com.everis.evaluacion1.services.ProductoService;
import com.everis.evaluacion1.services.UsuarioService;
import com.everis.evaluacion1.services.VentaService;

@RestController
public class ApiController {

	@Autowired
	ProductoService productoService;
	@Autowired
	UsuarioService usuarioService;

	@Autowired
	VentaService ventasService;

	@RequestMapping("/get-productos")
	public List<Producto> listaProducto() {

		List<Producto> productos_lista = productoService.allProductos();
		return productos_lista;

	}

	@RequestMapping("/get-usuarios")
	public List<Usuario> listaUsuario() {

		List<Usuario> usuarios_lista = usuarioService.allUsuarios();
		return usuarios_lista;

	}

	@RequestMapping("/get-ventas")
	public List<Venta> listaVentas() {

		List<Venta> ventas_lista = ventasService.allVentas();
		return ventas_lista;

	}

}
