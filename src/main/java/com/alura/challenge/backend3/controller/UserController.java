package com.alura.challenge.backend3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alura.challenge.backend3.exception.EmailInUseException;
import com.alura.challenge.backend3.model.Usuario;
import com.alura.challenge.backend3.service.CadastroService;

@Controller
public class UserController {

	@Autowired
	private CadastroService cadastroService;

	private static final String REDIRECT = "redirect:/";

	@GetMapping("/cadastro_usuario")
	public String getUserRegisterForm() {
		return "cadastro";
	}

	@GetMapping("/lista_usuarios")
	public String getUserListForm(Model model) {
		model.addAttribute("usuarios", cadastroService.listAllUsers());
		return "usuarios";
	}

	@PostMapping("/salvarUsuario")
	public String userRegisterForm(@ModelAttribute("user") Usuario user, RedirectAttributes attributes) {
		try {
			cadastroService.cadastraUsuario(user);
		} catch (EmailInUseException e) {
			attributes.addFlashAttribute("message", "Este email já está em uso!");
			return REDIRECT;
		}
		return "redirect:/lista_usuarios"; 
	}

	@DeleteMapping("/removerUsuario")
	public String userDelete(@ModelAttribute("user") Usuario user) {
		cadastroService.removeUser(user);
		return "usuarios";
	} 

	@PatchMapping("/editarUsuario")
	public String userUpdate(@ModelAttribute("user") Usuario user) {
		cadastroService.updateUser(user);
		return "usuarios";
	}

}
