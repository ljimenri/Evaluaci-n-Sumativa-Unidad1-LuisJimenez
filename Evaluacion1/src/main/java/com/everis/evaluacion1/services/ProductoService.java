package com.everis.evaluacion1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.evaluacion1.models.Producto;
import com.everis.evaluacion1.repositories.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	public boolean guardarProducto(Producto producto) {
		productoRepository.save(producto);
		return false;
	}

	public List<Producto> allProductos() {
		return (List<Producto>) productoRepository.findAll();
	}

	public void deleteById(Long id) {
		productoRepository.deleteById(id);

	}

}
