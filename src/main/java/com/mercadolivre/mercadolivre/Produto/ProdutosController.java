package com.mercadolivre.mercadolivre.Produto;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mercadolivre.mercadolivre.UsuarioLogado;
import com.mercadolivre.mercadolivre.Produto.Imagem.ImagemDto;
import com.mercadolivre.mercadolivre.Produto.Imagem.UploaderFake;
import com.mercadolivre.mercadolivre.Usuario.Usuario;
import com.mercadolivre.mercadolivre.Validation.ProibeCararcteristicasNomeIguaisValidator;

@RestController
public class ProdutosController {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private UploaderFake uploaderFake;

	@InitBinder(value = "novoProdutoRequest")
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new ProibeCararcteristicasNomeIguaisValidator());
	}

	@PostMapping("/produtos")
	@Transactional
	public String cadastraProduto(@RequestBody @Valid ProdutoDto dto,
			@AuthenticationPrincipal UsuarioLogado usuarioLogado) {
		Usuario dono = usuarioLogado.get();
		Produto produto = dto.toModel(manager, dono);
		return produto.toString();
	}

	@PostMapping("/produtos/{id}/imagens")
	@Transactional
	public String adicionaImagens(@PathVariable Long id, @RequestBody @Valid ImagemDto dto,
			@AuthenticationPrincipal UsuarioLogado usuarioLogado) {
		Usuario dono = usuarioLogado.get();
		Produto produto = manager.find(Produto.class, id);

		if (!produto.pertenceAoUsuario(dono)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}

		Set<String> links = uploaderFake.envia(dto.getImagens());
		produto.associaImagens(links);

		manager.merge(produto);

		return produto.toString();

	}

}