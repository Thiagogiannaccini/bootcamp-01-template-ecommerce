package com.mercadolivre.mercadolivre.FluxoCompra;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class RetornoPaypalRequest implements RetornoGatewayPagamento {

	private @Min(0) @Max(1) int status;
	private @NotBlank String idTransacao;

	public RetornoPaypalRequest(@Min(0) @Max(1) int status, @NotBlank String idTransacao) {
		super();
		this.status = status;
		this.idTransacao = idTransacao;
	}

	public Transacao toTransacao(Compra compra) {
		StatusTransacao checaStatus = this.status == 0 ? StatusTransacao.erro : StatusTransacao.sucesso;

		return new Transacao(checaStatus, idTransacao, compra);
	}

}