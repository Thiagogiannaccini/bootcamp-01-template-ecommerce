package com.mercadolivre.mercadolivre.OutroSistemas;

import com.sun.istack.NotNull;

public class RankingCompra {

	@NotNull
	private Long idCompra;
	@NotNull
	private Long idDonoProduto;

	public RankingCompra(Long idCompra, Long idDonoProduto) {
		super();
		this.idCompra = idCompra;
		this.idDonoProduto = idDonoProduto;
	}

	@Override
	public String toString() {
		return "NotaFiscalCompra [idCompra=" + idCompra + ", idComprador="
				+ idDonoProduto + "]";
	}

}