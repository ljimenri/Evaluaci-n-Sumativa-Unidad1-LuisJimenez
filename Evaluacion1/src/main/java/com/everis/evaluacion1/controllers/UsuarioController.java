package com.everis.evaluacion1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.evaluacion1.models.Usuario;
import com.everis.evaluacion1.services.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping("/")
	public String usuarios(Model model) {
		List<Usuario> lista = usuarioService.allUsuarios();
		model.addAttribute("usuarios", lista);
		return "usuario.jsp";

	}

	@RequestMapping("/submit-usuario")
	public String submitUsuario(@RequestParam(value = "nombreCompleto") String nombreCompleto,
			@RequestParam(value = "rut") String rut, @RequestParam(value = "contrasenia") String contrasenia,
			Model model) {

		Usuario usuario = new Usuario(nombreCompleto, rut, contrasenia);
		boolean insertar = usuarioService.guardarUsuario(usuario);

		List<Usuario> lista = usuarioService.allUsuarios();
		model.addAttribute("usuarios", lista);
		return "usuario.jsp";

	}

	@RequestMapping("/eliminar-usuario")
	public String eliminarUsuario(@RequestParam(value = "id") Long id, Model model) {

		usuarioService.deleteById(id);
		List<Usuario> lista = usuarioService.allUsuarios();
		model.addAttribute("usuarios", lista);

		return "usuario.jsp";

	}

}
