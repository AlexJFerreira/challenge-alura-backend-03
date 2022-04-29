package com.alura.challenge.backend3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.challenge.backend3.exception.EmailInUseException;
import com.alura.challenge.backend3.model.Usuario;
import com.alura.challenge.backend3.utils.Utils;

@Service
public class CadastroService {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EmailService emailService;

	public void cadastraUsuario(Usuario usuario) throws EmailInUseException {

		Optional<Usuario> user = usuarioService.findUserByEmail(usuario.getEmail());

		if (user.isPresent()) {
			throw new EmailInUseException("Email já está em uso!");
		}

		usuario.setSenha(Utils.generateRandomDefaultPassword());
		usuarioService.createUser(usuario);
		
		emailService.sendSimpleMessage(usuario.getEmail(), usuario.getSenha());

	}

	public List<Usuario> listAllUsers() {
		return usuarioService.getAllUsers();
	}

	public void removeUser(Usuario user) {
		usuarioService.removeUser(user);
	}

	public void updateUser(Usuario user) {
		usuarioService.updateUser(user);		
	}

}
