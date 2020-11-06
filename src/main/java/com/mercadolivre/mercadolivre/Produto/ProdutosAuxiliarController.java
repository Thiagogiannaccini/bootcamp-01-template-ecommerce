package com.mercadolivre.mercadolivre.Produto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutosAuxiliarController {

	@PersistenceContext 
	private EntityManager manager;

	@GetMapping("/listarProdutos")
	public String listaProdutos() {
		return manager.createQuery("select p from Produto p").getResultList().toString();
	}
	
	@GetMapping("/listarUsuarios")
	public String listaUsuarios() {
		return manager.createQuery("select u from Usuario u").getResultList().toString();
	}

}