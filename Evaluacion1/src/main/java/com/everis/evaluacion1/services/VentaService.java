package com.everis.evaluacion1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.evaluacion1.models.Venta;
import com.everis.evaluacion1.repositories.VentaRepository;

@Service
public class VentaService {

	@Autowired
	VentaRepository ventaRepository;

	public boolean guardarVenta(Venta venta) {

		ventaRepository.save(venta);
		return false;
	}

	public List<Venta> allVentas() {

		return (List<Venta>) ventaRepository.findAll();
	}

	public void deleteById(Long id) {
		ventaRepository.deleteById(id);

	}
}
