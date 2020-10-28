package com.mercadolivre.mercadolivre.Produto.Opiniao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolivre.mercadolivre.UsuarioLogado;
import com.mercadolivre.mercadolivre.Produto.Produto;
import com.mercadolivre.mercadolivre.Usuario.Usuario;

@RestController
public class OpinioesController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping("/produto/{id}/opiniao")
	@Transactional
	public String adicionaOpiniao(@RequestBody @Valid OpiniaoDto dto, @PathVariable Long id,
			@AuthenticationPrincipal UsuarioLogado usuarioLogado) {
		Produto produto = manager.find(Produto.class, id);
		Usuario consumidor = usuarioLogado.get();

		Opiniao novaOpiniao = dto.toModel(produto, consumidor);
		manager.persist(novaOpiniao);

		return novaOpiniao.toString();
	}
}