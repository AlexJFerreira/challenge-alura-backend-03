package com.alura.challenge.backend3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alura.challenge.backend3.service.TransacaoService;

@Controller
public class FormController {
	
	@Autowired
	private TransacaoService transacaoService;

	@GetMapping("/")
	public String getForm() {
		return "index";
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws Exception {

		if (file.isEmpty()) {
			attributes.addFlashAttribute("message", "Please select a file to upload.");
			return "redirect:/";
		}

		transacaoService.processaTransacao(file);

		return "redirect:/";
	}



}
