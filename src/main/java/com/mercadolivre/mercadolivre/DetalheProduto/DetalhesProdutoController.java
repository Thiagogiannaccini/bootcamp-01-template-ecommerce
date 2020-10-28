package com.mercadolivre.mercadolivre.DetalheProduto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolivre.mercadolivre.Produto.Produto;

@RestController
public class DetalhesProdutoController {


	@PersistenceContext
	private EntityManager manager;

	@GetMapping(value = "/produtos/{id}")
	public DetalheProdutoResponse detalhaProduto(@PathVariable("id") Long id) {
		Produto produto = manager.find(Produto.class, id);
		return new DetalheProdutoResponse(produto);
	}


}
