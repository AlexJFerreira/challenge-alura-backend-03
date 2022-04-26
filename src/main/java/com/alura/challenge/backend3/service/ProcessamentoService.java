package com.alura.challenge.backend3.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alura.challenge.backend3.exception.EmptyFileException;
import com.alura.challenge.backend3.exception.ProcessedDateException;
import com.alura.challenge.backend3.model.Importacao;

@Service
public class ProcessamentoService {
	
	@Autowired
	private TransacaoService transacaoService;
	
	@Autowired
	private ImportacaoService importacaoService;
	
	public void processaArquivo(MultipartFile file) throws IOException, EmptyFileException, ProcessedDateException {		
		importacaoService.processaImportacao(transacaoService.recuperaTransacoes(file));
	}
	
	public List<Importacao> recuperaImportacoes() {		
		return importacaoService.recuperaImportacoes();
	}

}
