package com.mercadolivre.mercadolivre.Usuario;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.mercadolivre.mercadolivre.Validation.ValorUnico;
import com.sun.istack.NotNull;

public class UsuarioDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank @Email @ValorUnico(classe = Usuario.class, campo = "email") String email;
	private @NotBlank @Length(min = 6) String senha;
	private @NotNull LocalDateTime instanteCriacao = LocalDateTime.now();

	public UsuarioDto(@NotBlank @Email String email, @NotBlank @Length(min = 6) String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public Usuario toModel() {
		return new Usuario(email,new SenhaLimpa(senha));
	}

}