package com.mercadolivre.mercadolivre.FluxoCompra;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Service
public class Ranking implements EventoCompraSucesso {

	@Override
	public void processaCompra(Compra compra) {
		Assert.isTrue(compra.processadaComSucesso(), "A compra não pode ser processada" + compra);

		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> request = Map.of("idCompra", compra.getId(), "idDonoProduto",
				compra.getDonoProduto().getId());

		restTemplate.postForEntity("http://localhost:8080/ranking", request, String.class);
	}

}