package com.mercadolivre.mercadolivre.Produto.Pergunta;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolivre.mercadolivre.UsuarioLogado;
import com.mercadolivre.mercadolivre.Produto.Produto;
import com.mercadolivre.mercadolivre.Produto.Pergunta.Email.Emails;
import com.mercadolivre.mercadolivre.Usuario.Usuario;

@RestController
public class PerguntasController {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private Emails emails;

	@PostMapping("/produtos/{id}/perguntas")
	@Transactional
	public String criaPergunta(@RequestBody @Valid PerguntaDto dto, @PathVariable("id") Long id,
			@AuthenticationPrincipal UsuarioLogado usuarioLogado) {
		Produto produto = manager.find(Produto.class, id);
		Usuario interessada = usuarioLogado.get();

		Pergunta novaPergunta = dto.toModel(interessada, produto);
		manager.persist(novaPergunta);

		emails.novaPergunta(novaPergunta);
		return novaPergunta.toString();
	}

}