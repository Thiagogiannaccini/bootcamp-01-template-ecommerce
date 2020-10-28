package com.mercadolivre.mercadolivre.Produto.Pergunta;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.mercadolivre.mercadolivre.Produto.Produto;
import com.mercadolivre.mercadolivre.Usuario.Usuario;
import com.sun.istack.NotNull;

public class PerguntaDto {

	private @NotBlank String titulo;

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "NovaPerguntaRequest [titulo=" + titulo + "]";
	}

	public Pergunta toModel(@NotNull @Valid Usuario interessada, @NotNull @Valid Produto produto) {
		return new Pergunta(titulo, interessada, produto);
	}

}
