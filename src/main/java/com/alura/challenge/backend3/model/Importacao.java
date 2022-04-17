package com.alura.challenge.backend3.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Importacao {

	public Importacao() {
	}

	public Importacao(LocalDate dataTransacaoImportacao, List<Transacao> transacoes) {
		this.dataTransacaoImportacao = dataTransacaoImportacao;
		this.transacoes = transacoes;
	}

	@Id
	@Column(name = "data_transacao_importacao")
	private LocalDate dataTransacaoImportacao;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "data_transacao_importacao")
	private List<Transacao> transacoes;

	@Column(name = "data_hora_importacao", nullable = false)
	private LocalDateTime dataHoraImportacao = LocalDateTime.now();

	public LocalDate getDataTransacaoImportacao() {
		return dataTransacaoImportacao;
	}

	public void setDataTransacaoImportacao(LocalDate dataTransacaoImportacao) {
		this.dataTransacaoImportacao = dataTransacaoImportacao;
	}

	public LocalDateTime getDataHoraImportacao() {
		return dataHoraImportacao;
	}

	public void setDataHoraImportacao(LocalDateTime dataHoraImportacao) {
		this.dataHoraImportacao = dataHoraImportacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataHoraImportacao, dataTransacaoImportacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Importacao other = (Importacao) obj;
		return Objects.equals(dataHoraImportacao, other.dataHoraImportacao)
				&& Objects.equals(dataTransacaoImportacao, other.dataTransacaoImportacao);
	}

	@Override
	public String toString() {
		return "Importacao [dataTransacaoImportacao=" + dataTransacaoImportacao + ", dataHoraImportacao="
				+ dataHoraImportacao + "]";
	}

}
