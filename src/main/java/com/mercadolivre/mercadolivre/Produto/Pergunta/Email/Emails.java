package com.mercadolivre.mercadolivre.Produto.Pergunta.Email;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.mercadolivre.mercadolivre.Produto.Pergunta.Pergunta;
import com.sun.istack.NotNull;

public class Emails {
	
	@Autowired

	private Mailer mailer;

	//1
	public void novaPergunta(@NotNull @Valid Pergunta pergunta) {
		mailer.send("Qual sua duvida?","Nova pergunta...",pergunta.getInteressada().getEmail(),"novapergunta@nossomercadolivre.com",pergunta.getDonoProduto().getEmail());
	}

}
