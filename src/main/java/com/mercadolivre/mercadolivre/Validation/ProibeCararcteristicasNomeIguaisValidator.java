package com.mercadolivre.mercadolivre.Validation;

import java.util.Set;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mercadolivre.mercadolivre.Produto.ProdutoDto;

public class ProibeCararcteristicasNomeIguaisValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ProdutoDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return ;
		}
		
		ProdutoDto request = (ProdutoDto) target;
		Set<String> verificarNome = request.buscaCaracteristicasIguais();
		if(!verificarNome.isEmpty()) {
			errors.rejectValue("caracteristicas", null, "Essa caracteristica já consta nesse produto "+verificarNome);
		}
	}

}