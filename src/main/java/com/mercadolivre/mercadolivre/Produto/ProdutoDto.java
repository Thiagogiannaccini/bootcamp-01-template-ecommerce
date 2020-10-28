package com.mercadolivre.mercadolivre.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.mercadolivre.mercadolivre.Categoria.Categoria;
import com.mercadolivre.mercadolivre.Produto.Caracteristica.CaracteristicaDto;
import com.mercadolivre.mercadolivre.Usuario.Usuario;
import com.sun.istack.NotNull;

public class ProdutoDto {

	private @NotBlank String nome;
	private @NotNull int quantidade;
	private @NotBlank @Length(max = 1000) String descricao;
	private @NotNull @Positive BigDecimal valor;
	private @NotNull Long idCategoria;
	private @Valid @Size(min = 3) List<CaracteristicaDto> caracteristicas = new ArrayList<>();

	public ProdutoDto(@NotBlank String nome, @NotBlank int quantidade, @NotBlank @Length(max = 1000) String descricao,
			@Positive BigDecimal valor, Long idCategoria, List<CaracteristicaDto> caracteristicas) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.valor = valor;
		this.idCategoria = idCategoria;
		this.caracteristicas.addAll(caracteristicas);
	}

	public Produto toModel(EntityManager manager, Usuario dono) {
		Categoria categoria = manager.find(Categoria.class, idCategoria);
		return new Produto(nome, quantidade, descricao, valor, categoria, dono, caracteristicas);
	}

	public String getNome() {
		return nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public List<CaracteristicaDto> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<CaracteristicaDto> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public Set<String> buscaCaracteristicasIguais() {
		HashSet<String> verificarNome = new HashSet<>();
		HashSet<String> nomeVerificado = new HashSet<>();

		for (CaracteristicaDto caracteristica : caracteristicas) {
			String nome = caracteristica.getNome();

			if (!verificarNome.add(nome)) {
				nomeVerificado.add(nome);
			}
		}
		return nomeVerificado;
	}

}
