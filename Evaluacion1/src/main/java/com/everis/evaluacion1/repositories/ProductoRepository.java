package com.everis.evaluacion1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.everis.evaluacion1.models.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

	List<Producto> findAll();
}
