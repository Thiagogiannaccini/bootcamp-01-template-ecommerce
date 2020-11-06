package com.mercadolivre.mercadolivre.OutroSistemas;

import com.sun.istack.NotNull;

public class NotaFiscalCompra {

	private @NotNull Long idCompra;
	private @NotNull Long idComprador;

	public NotaFiscalCompra(Long idCompra, Long idComprador) {
		super();
		this.idCompra = idCompra;
		this.idComprador = idComprador;
	}

	@Override
	public String toString() {
		return "NotaFiscalCompra [idCompra=" + idCompra + ", idComprador="
				+ idComprador + "]";
	}
	
	public Long getIdCompra() {
		return idCompra;
	}
	
	public Long getIdComprador() {
		return idComprador;
	}

}


