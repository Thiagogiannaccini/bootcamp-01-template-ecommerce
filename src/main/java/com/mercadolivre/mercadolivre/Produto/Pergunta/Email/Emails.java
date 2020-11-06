package com.mercadolivre.mercadolivre.Produto.Pergunta.Email;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolivre.mercadolivre.FluxoCompra.Compra;
import com.mercadolivre.mercadolivre.Produto.Pergunta.Pergunta;
import com.sun.istack.NotNull;

@Service
public class Emails {

	@Autowired
	private Mailer mailer;

	public void novaPergunta(@NotNull @Valid Pergunta pergunta) {
		mailer.send("Qual sua duvida?", "Nova pergunta...", pergunta.getInteressada().getEmail(),
				"novapergunta@nossomercadolivre.com", pergunta.getDonoProduto().getEmail());
	}

	public void novaCompra(@NotNull @Valid Compra compra) {
		mailer.send("Possível nova compra " + compra, "Tem um cliente interessado no seu produto",
				compra.getComprador().getEmail(), "compras@nossomercadolivre.com", compra.getDonoProduto().getEmail());
	}


}
