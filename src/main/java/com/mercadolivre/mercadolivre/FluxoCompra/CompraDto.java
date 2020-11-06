package com.mercadolivre.mercadolivre.FluxoCompra;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CompraDto {

	private @Positive int quantidade;
	private @NotNull Long idProduto;
	private @NotNull GatewayPagamento gateway;

	public CompraDto(@Positive int quantidade, @NotNull Long idProduto, GatewayPagamento gateway) {
		super();
		this.quantidade = quantidade;
		this.idProduto = idProduto;
		this.gateway = gateway;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public GatewayPagamento getGateway() {
		return gateway;
	}

}