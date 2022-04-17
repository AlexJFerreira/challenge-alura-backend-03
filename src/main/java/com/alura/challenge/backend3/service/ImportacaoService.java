package com.alura.challenge.backend3.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.challenge.backend3.model.Importacao;
import com.alura.challenge.backend3.model.Transacao;
import com.alura.challenge.backend3.repository.ImportacaoRepository;

@Service
public class ImportacaoService {
	
	@Autowired
	private ImportacaoRepository importacaoRepository;

	public void processaImportacao(List<Transacao> transacoes) {
		final LocalDate dataProcessamentoTransacao = transacoes.get(0).getDataHoraTransacao().toLocalDate();
		final Importacao importacao = new Importacao(dataProcessamentoTransacao, transacoes);		
		importacaoRepository.saveAndFlush(importacao);
	}

	public List<Importacao> recuperaImportacoes() {
		return importacaoRepository.findAll();
	}

}
