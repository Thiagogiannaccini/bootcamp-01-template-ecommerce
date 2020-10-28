package com.mercadolivre.mercadolivre.DetalheProduto;

import com.mercadolivre.mercadolivre.Produto.Caracteristica.Caracteristica;

public class DetalheProduto {

	private String nome;
	private String descricao;

	public DetalheProduto(Caracteristica caracteristica) {
		this.nome = caracteristica.getNome();
		this.descricao = caracteristica.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
