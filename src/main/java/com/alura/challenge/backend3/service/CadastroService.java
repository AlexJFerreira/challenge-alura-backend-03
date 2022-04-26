package com.alura.challenge.backend3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.challenge.backend3.model.Usuario;

@Service
public class CadastroService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	public void cadastraUsuario(Usuario usuario) {
		usuario.setSenha("teste");
		usuarioService.createUser(usuario);
		
	}

}
