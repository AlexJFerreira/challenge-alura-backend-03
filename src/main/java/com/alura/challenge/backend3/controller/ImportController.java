package com.alura.challenge.backend3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alura.challenge.backend3.exception.EmptyFileException;
import com.alura.challenge.backend3.exception.ProcessedDateException;
import com.alura.challenge.backend3.model.Usuario;
import com.alura.challenge.backend3.service.CadastroService;
import com.alura.challenge.backend3.service.ProcessamentoService;

@Controller
public class ImportController {
		
	@Autowired
	private ProcessamentoService processamentoService;
	
	private static final String REDIRECT = "redirect:/";

	@GetMapping("/")
	public String getForm() {
		return "index";
	}
	
	@GetMapping("/listaImportacoes")
	public String getImportacoes(Model model) {
		model.addAttribute("importacoes",processamentoService.recuperaImportacoes());
		return "importacoes";
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws Exception {

		if (file.isEmpty()) {
			attributes.addFlashAttribute("message", "Por favor, selecione um arquivo para upload.");
			return REDIRECT;
		}

		try {
			processamentoService.processaArquivo(file);		
		} catch (EmptyFileException e) {
			attributes.addFlashAttribute("message", "Arquivo inserido está vazio, favor inserir um arquivo valido.");
			return REDIRECT;
		} catch (ProcessedDateException e) {
			attributes.addFlashAttribute("message", "Data já processada.");
			return REDIRECT;
		} 
		
		return "redirect:/listaImportacoes";			

	}



}
