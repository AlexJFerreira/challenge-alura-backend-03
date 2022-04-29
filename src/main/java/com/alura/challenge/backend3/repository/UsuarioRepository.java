package com.alura.challenge.backend3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.challenge.backend3.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
    public Optional<Usuario> findByEmail(String email);

}
