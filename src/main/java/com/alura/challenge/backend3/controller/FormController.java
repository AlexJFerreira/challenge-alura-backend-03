package com.alura.challenge.backend3.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alura.challenge.backend3.exception.EmptyFileException;
import com.alura.challenge.backend3.exception.ProcessedDateException;
import com.alura.challenge.backend3.service.ProcessamentoService;

@Controller
public class FormController {
	
	@Autowired
	private ProcessamentoService processamentoService;

	@GetMapping("/")
	public String getForm() {
		return "index";
	}
	
	@GetMapping("/listaImportacoes")
	public String getImportacoes(Model model) throws IOException, EmptyFileException, ProcessedDateException {
		model.addAttribute("importacoes",processamentoService.recuperaImportacoes());
		return "importacoes";
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws Exception {

		if (file.isEmpty()) {
			attributes.addFlashAttribute("message", "Por favor, selecione um arquivo para upload.");
			return "redirect:/";
		}

		try {
			processamentoService.processaArquivo(file);		
		} catch (EmptyFileException e) {
			attributes.addFlashAttribute("message", "Arquivo inserido está vazio, favor inserir um arquivo valido.");
			return "redirect:/";
		} catch (ProcessedDateException e) {
			attributes.addFlashAttribute("message", "Data já processada.");
			return "redirect:/";
		} 
		
		return "redirect:/listaImportacoes";			

	}



}
