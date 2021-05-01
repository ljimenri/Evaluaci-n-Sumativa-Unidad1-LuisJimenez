package com.everis.evaluacion1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.evaluacion1.models.Usuario;
import com.everis.evaluacion1.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public boolean guardarUsuario(Usuario usuario) {

		System.out.println("--USUARIO SERVICE--");
		usuarioRepository.save(usuario);
		return true;
	}

	public List<Usuario> allUsuarios() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioRepository.findAll();
	}

	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);

	}

}
