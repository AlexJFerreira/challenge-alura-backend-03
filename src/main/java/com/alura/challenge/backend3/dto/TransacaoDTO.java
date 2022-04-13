package com.alura.challenge.backend3.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

public class TransacaoDTO {

	@CsvBindByPosition(position = 0)
	private String bancoOrigem;

	@CsvBindByPosition(position = 1)
	private String agenciaOrigem;

	@CsvBindByPosition(position = 2)
	private String contaOrigem;

	@CsvBindByPosition(position = 3)
	private String bancoDestino;

	@CsvBindByPosition(position = 4)
	private String agenciaDestino;

	@CsvBindByPosition(position = 5)
	private String contaDestino;

	@CsvBindByPosition(position = 6)
	private BigDecimal valorTransacao;

	@CsvBindByPosition(position = 7)
	@CsvDate(value = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime dataHoraTransacao;

	public String getBancoOrigem() {
		return bancoOrigem;
	}

	public String getAgenciaOrigem() {
		return agenciaOrigem;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public String getBancoDestino() {
		return bancoDestino;
	}

	public String getAgenciaDestino() {
		return agenciaDestino;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public BigDecimal getValorTransacao() {
		return valorTransacao;
	}

	public LocalDateTime getDataHoraTransacao() {
		return dataHoraTransacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agenciaDestino, agenciaOrigem, bancoDestino, bancoOrigem, contaDestino, contaOrigem,
				dataHoraTransacao, valorTransacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransacaoDTO other = (TransacaoDTO) obj;
		return Objects.equals(agenciaDestino, other.agenciaDestino)
				&& Objects.equals(agenciaOrigem, other.agenciaOrigem)
				&& Objects.equals(bancoDestino, other.bancoDestino) && Objects.equals(bancoOrigem, other.bancoOrigem)
				&& Objects.equals(contaDestino, other.contaDestino) && Objects.equals(contaOrigem, other.contaOrigem)
				&& Objects.equals(dataHoraTransacao, other.dataHoraTransacao)
				&& Objects.equals(valorTransacao, other.valorTransacao);
	}

	@Override
	public String toString() {
		return "TransacaoDTO [bancoOrigem=" + bancoOrigem + ", agenciaOrigem=" + agenciaOrigem + ", contaOrigem="
				+ contaOrigem + ", bancoDestino=" + bancoDestino + ", agenciaDestino=" + agenciaDestino
				+ ", contaDestino=" + contaDestino + ", valorTransacao=" + valorTransacao + ", dataHoraTransacao="
				+ dataHoraTransacao + "]";
	}

}
