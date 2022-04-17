package com.alura.challenge.backend3.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.challenge.backend3.model.Importacao;

public interface ImportacaoRepository extends JpaRepository<Importacao, LocalDate> {
	
    public List<Importacao> findAllByOrderByDataTransacaoImportacaoDesc();


}
