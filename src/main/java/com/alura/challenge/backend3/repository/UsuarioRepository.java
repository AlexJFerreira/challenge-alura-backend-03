package com.alura.challenge.backend3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.challenge.backend3.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
