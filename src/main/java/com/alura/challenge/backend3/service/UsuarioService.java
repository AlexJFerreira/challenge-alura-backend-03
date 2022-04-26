package com.alura.challenge.backend3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.challenge.backend3.model.Usuario;
import com.alura.challenge.backend3.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	private List<Usuario> getAllUsers(){
		return repository.findAll();
	}
	
	private Usuario getUserById(final Integer id){
		return repository.getById(id);
	}
	
	private void deleteUserById(final Integer id){
		repository.deleteById(id);
	}
	
	public Usuario createUser(final Usuario user){
		return repository.save(user);
	}
	
	private Usuario updateUser(final Usuario user){
		return repository.save(user);
	}

}
