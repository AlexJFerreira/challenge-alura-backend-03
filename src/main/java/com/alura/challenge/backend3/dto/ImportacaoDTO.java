package com.alura.challenge.backend3.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ImportacaoDTO {

	private LocalDate dataTransacaoImportacao;
	private List<TransacaoDTO> transacoes;
	private LocalDateTime dataHoraImportacao = LocalDateTime.now();

	public LocalDate getDataTransacaoImportacao() {
		return dataTransacaoImportacao;
	}

	public void setDataTransacaoImportacao(LocalDate dataTransacaoImportacao) {
		this.dataTransacaoImportacao = dataTransacaoImportacao;
	}

	public List<TransacaoDTO> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<TransacaoDTO> transacoes) {
		this.transacoes = transacoes;
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
		ImportacaoDTO other = (ImportacaoDTO) obj;
		return Objects.equals(dataHoraImportacao, other.dataHoraImportacao)
				&& Objects.equals(dataTransacaoImportacao, other.dataTransacaoImportacao);
	}

	@Override
	public String toString() {
		return "ImportacaoDTO [dataTransacaoImportacao=" + dataTransacaoImportacao + ", dataHoraImportacao="
				+ dataHoraImportacao + "]";
	}

}
