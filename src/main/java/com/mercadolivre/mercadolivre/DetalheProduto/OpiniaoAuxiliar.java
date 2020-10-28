package com.mercadolivre.mercadolivre.DetalheProduto;

import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.mercadolivre.mercadolivre.Produto.Opiniao.Opiniao;

//classe destinada a receber as opinioes e notas para calcular sua media, passando para a clase de detalhes

public class OpiniaoAuxiliar {
	private Set<Opiniao> opinioes;

	public OpiniaoAuxiliar(Set<Opiniao> opinioes) {
		this.opinioes = opinioes;
	}

	public <T> Set<T> mapeiaOpinioes(Function<Opiniao, T> funcaoMapeadora) {
		return this.opinioes.stream().map(funcaoMapeadora).collect(Collectors.toSet());
	}

	public double media() {
		Set<Integer> notas = mapeiaOpinioes(opiniao -> opiniao.getNota());
		OptionalDouble possivelMedia = notas.stream().mapToInt(nota -> nota).average();
		return possivelMedia.orElse(0.0);
	}

	public int total() {
		return this.opinioes.size();
	}

}
