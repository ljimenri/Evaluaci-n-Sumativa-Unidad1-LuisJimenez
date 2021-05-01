package com.everis.evaluacion1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.evaluacion1.models.Venta;
import com.everis.evaluacion1.services.VentaService;

@Controller
public class VentaController {

	@Autowired
	VentaService ventaService;

	@RequestMapping("/venta")
	public String ventas(Model model) {

		List<Venta> lista = ventaService.allVentas();
		model.addAttribute("ventas", lista);
		return "venta.jsp";

	}

	@RequestMapping("/submit-venta")
	public String submitProducto(@RequestParam(value = "nombreProducto") String nombreProducto,
			@RequestParam(value = "cantidad") String cantidad, Model model) {

		Venta venta = new Venta(nombreProducto, cantidad);
		boolean insertar = ventaService.guardarVenta(venta);

		List<Venta> lista = ventaService.allVentas();
		model.addAttribute("ventas", lista);

		// Redirige y manda datos
		return "venta.jsp";

	}

	@RequestMapping("/eliminar-venta")
	public String eliminar(@RequestParam(value = "id") Long id, Model model) {

		ventaService.deleteById(id);
		List<Venta> lista = ventaService.allVentas();
		model.addAttribute("ventas", lista);
		return "venta.jsp";

	}

}
