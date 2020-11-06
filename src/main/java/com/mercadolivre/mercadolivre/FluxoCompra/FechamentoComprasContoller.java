package com.mercadolivre.mercadolivre.FluxoCompra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mercadolivre.mercadolivre.UsuarioLogado;
import com.mercadolivre.mercadolivre.Produto.Produto;
import com.mercadolivre.mercadolivre.Produto.Pergunta.Email.Emails;
import com.mercadolivre.mercadolivre.Usuario.Usuario;

@RestController
public class FechamentoComprasContoller {

	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private Emails emails;

	@PostMapping("/compras")
	@Transactional
	public String cria(@RequestBody @Valid CompraDto dto, UriComponentsBuilder uriComponentsBuilder,
			@AuthenticationPrincipal UsuarioLogado usuarioLogado) throws BindException {
		Produto produtoASerComprado = manager.find(Produto.class, dto.getIdProduto());
		int quantidade = dto.getQuantidade();
		boolean ajustou = produtoASerComprado.ajustaEstoque(quantidade);

		if (ajustou) {
			Usuario comprador = usuarioLogado.get();
			GatewayPagamento gateway = dto.getGateway();
			Compra novaCompra = new Compra(produtoASerComprado, quantidade, comprador, gateway);
			manager.persist(novaCompra);
			emails.novaCompra(novaCompra);
			return novaCompra.urlRedirecionamento(uriComponentsBuilder);
		}

		BindException erroEstoque = new BindException(dto, "compraDto");
		erroEstoque.reject(null, "A compra não pode ser realizada!");
		throw erroEstoque;

	}
}
