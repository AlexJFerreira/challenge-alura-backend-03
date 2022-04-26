package com.alura.challenge.backend3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alura.challenge.backend3.model.Usuario;
import com.alura.challenge.backend3.service.CadastroService;

@Controller
public class UserRegisterController {
	
	@Autowired
	private CadastroService cadastroService;
	
	@GetMapping("/cadastro_usuario")
	public String getUserRegisterForm() {
		return "cadastro";
	}
	
	@PostMapping("/salvarUsuario")
	public String userRegisterForm(@ModelAttribute ("user") Usuario user) {
		System.out.println("usuario "+user);
		cadastroService.cadastraUsuario(user);
		return "cadastro";
	}

}
