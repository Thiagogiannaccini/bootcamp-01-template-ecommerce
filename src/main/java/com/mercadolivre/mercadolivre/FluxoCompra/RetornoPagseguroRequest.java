package com.mercadolivre.mercadolivre.FluxoCompra;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RetornoPagseguroRequest implements RetornoGatewayPagamento {

	private @NotBlank String idTransacao;
	private @NotNull StatusRetornoPagseguro status;

	public RetornoPagseguroRequest(@NotBlank String idTransacao, StatusRetornoPagseguro status) {
		super();
		this.idTransacao = idTransacao;
		this.status = status;
	}

	@Override
	public String toString() {
		return "RetornoPagseguroRequest [idTransacao=" + idTransacao + ", status=" + status + "]";
	}

	public Transacao toTransacao(Compra compra) {
		return new Transacao(status.normaliza(), idTransacao, compra);
	}

}
