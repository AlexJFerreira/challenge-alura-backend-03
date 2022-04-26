package com.alura.challenge.backend3.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transacao", nullable = false)
	private Integer id;

	@Column(name = "banco_origem", nullable = false)
	private String bancoOrigem;

	@Column(name = "agencia_origem", nullable = false)
	private String agenciaOrigem;

	@Column(name = "conta_origem", nullable = false)
	private String contaOrigem;

	@Column(name = "banco_destino", nullable = false)
	private String bancoDestino;

	@Column(name = "agencia_destino", nullable = false)
	private String agenciaDestino;

	@Column(name = "conta_destino", nullable = false)
	private String contaDestino;

	@Column(name = "valor_transacao", nullable = false)
	private BigDecimal valorTransacao;

	@Column(name = "data_hora_transacao", nullable = false)
	private LocalDateTime dataHoraTransacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBancoOrigem() {
		return bancoOrigem;
	}

	public void setBancoOrigem(String bancoOrigem) {
		this.bancoOrigem = bancoOrigem;
	}

	public String getAgenciaOrigem() {
		return agenciaOrigem;
	}

	public void setAgenciaOrigem(String agenciaOrigem) {
		this.agenciaOrigem = agenciaOrigem;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getBancoDestino() {
		return bancoDestino;
	}

	public void setBancoDestino(String bancoDestino) {
		this.bancoDestino = bancoDestino;
	}

	public String getAgenciaDestino() {
		return agenciaDestino;
	}

	public void setAgenciaDestino(String agenciaDestino) {
		this.agenciaDestino = agenciaDestino;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(BigDecimal valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public LocalDateTime getDataHoraTransacao() {
		return dataHoraTransacao;
	}

	public void setDataHoraTransacao(LocalDateTime dataHoraTransacao) {
		this.dataHoraTransacao = dataHoraTransacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agenciaDestino, agenciaOrigem, bancoDestino, bancoOrigem, contaDestino, contaOrigem,
				dataHoraTransacao, id, valorTransacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		return Objects.equals(agenciaDestino, other.agenciaDestino)
				&& Objects.equals(agenciaOrigem, other.agenciaOrigem)
				&& Objects.equals(bancoDestino, other.bancoDestino) && Objects.equals(bancoOrigem, other.bancoOrigem)
				&& Objects.equals(contaDestino, other.contaDestino) && Objects.equals(contaOrigem, other.contaOrigem)
				&& Objects.equals(dataHoraTransacao, other.dataHoraTransacao) && id == other.id
				&& Objects.equals(valorTransacao, other.valorTransacao);
	}

	@Override
	public String toString() {
		return "Transacao [id=" + id + ", bancoOrigem=" + bancoOrigem + ", agenciaOrigem=" + agenciaOrigem
				+ ", contaOrigem=" + contaOrigem + ", bancoDestino=" + bancoDestino + ", agenciaDestino="
				+ agenciaDestino + ", contaDestino=" + contaDestino + ", valorTransacao=" + valorTransacao
				+ ", dataHoraTransacao=" + dataHoraTransacao + "]";
	}

}
