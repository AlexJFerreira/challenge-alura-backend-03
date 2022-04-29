package com.alura.challenge.backend3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.challenge.backend3.model.Usuario;
import com.alura.challenge.backend3.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario createUser(final Usuario user){
		return repository.save(user);
	}
	
	public Optional<Usuario> findUserByEmail(final String email){
		return repository.findByEmail(email);
	}
	
	public List<Usuario> getAllUsers(){
		return repository.findAll();
	}
	
	public void removeUser(Usuario user){
		repository.delete(user);
	}
	
	public Usuario updateUser(final Usuario user){
		return repository.saveAndFlush(user);
	}

}
