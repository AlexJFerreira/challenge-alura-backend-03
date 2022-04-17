package com.alura.challenge.backend3.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.challenge.backend3.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{
	
	List<Transacao> findByDataHoraTransacaoBetween(LocalDateTime from, LocalDateTime to);
}

