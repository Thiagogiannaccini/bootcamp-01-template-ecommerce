package com.mercadolivre.mercadolivre.Produto.Caracteristica;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.mercadolivre.mercadolivre.Produto.Produto;
import com.sun.istack.NotNull;

public class CaracteristicaDto {

	private @NotBlank String nome;
	private @NotBlank String descricao;

	public CaracteristicaDto(@NotBlank String nome, @NotBlank String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return "NovaCaracteristicaRequest [nome=" + nome + ", descricao=" + descricao + "]";
	}

	public Caracteristica toModel(@NotNull @Valid Produto produto) {
		return new Caracteristica(nome, descricao, produto);
	}
}