package com.mercadolivre.mercadolivre.Produto.Pergunta;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.mercadolivre.mercadolivre.Produto.Produto;
import com.mercadolivre.mercadolivre.Usuario.Usuario;
import com.sun.istack.NotNull;

@Entity
public class Pergunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String titulo;
	@ManyToOne
	private @NotNull @Valid Usuario interessada;
	@ManyToOne
	private @NotNull @Valid Produto produto;
	private LocalDate instante;

	@Deprecated
	public Pergunta() {

	}

	public Pergunta(@NotBlank String titulo, @NotNull @Valid Usuario interessada, @NotNull @Valid Produto produto) {
		this.titulo = titulo;
		this.interessada = interessada;
		this.produto = produto;
		this.instante = LocalDate.now();
	}

	@Override
	public String toString() {
		return "Pergunta [id=" + id + ", titulo=" + titulo + ", interessada=" + interessada + ", produto=" + produto
				+ ", instante=" + instante + "]";
	}

	public String getTitulo() {
		return titulo;
	}

	public Usuario getInteressada() {
		return interessada;
	}

	public Produto getProduto() {
		return produto;
	}

	public Usuario getDonoProduto() {
		return produto.getDono();
	}

}
