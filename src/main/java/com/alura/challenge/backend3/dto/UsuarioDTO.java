package com.alura.challenge.backend3.dto;

import java.util.Objects;

public class UsuarioDTO {

	private String nome;
	private String email;

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "UsuarioDTO [nome=" + nome + ", email=" + email + "]";
	}

}
