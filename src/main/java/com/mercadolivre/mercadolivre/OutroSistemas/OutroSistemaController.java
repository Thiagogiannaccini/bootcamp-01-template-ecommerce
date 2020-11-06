package com.mercadolivre.mercadolivre.OutroSistemas;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class OutroSistemaController {

	@PostMapping("/notas-fiscais")
	public void criaNota(@Valid @RequestBody NotaFiscalCompra dto) throws InterruptedException {
		System.out.println("Nota fiscal sendo criada... "+dto);
		Thread.sleep(150);
	}
	
	@PostMapping("/ranking")
	public void ranking(@Valid @RequestBody RankingCompra dto) throws InterruptedException {
		System.out.println("Ranking está sendo criado..."+dto);
		Thread.sleep(150);
	}

}