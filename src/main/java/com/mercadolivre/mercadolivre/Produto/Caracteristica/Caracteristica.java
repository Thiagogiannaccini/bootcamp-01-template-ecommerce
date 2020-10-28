package com.mercadolivre.mercadolivre.Produto.Caracteristica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.mercadolivre.mercadolivre.Produto.Produto;
import com.sun.istack.NotNull;

@Entity
public class Caracteristica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String nome;
	private @NotBlank String descricao;
	@ManyToOne
	private @NotNull @Valid Produto produto;

	@Deprecated
	public Caracteristica() {

	}

	public Caracteristica(@NotBlank String nome, @NotBlank String descricao, @NotNull @Valid Produto produto) {
		this.nome = nome;
		this.descricao = descricao;
		this.produto = produto;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return "CaracteristicaProduto [nome=" + nome + ", descricao=" + descricao + "]";
	}

}
