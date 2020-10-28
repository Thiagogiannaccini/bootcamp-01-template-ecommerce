package com.mercadolivre.mercadolivre.Usuario;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.sun.istack.NotNull;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String email;
	private @NotBlank @Length(min = 6) String senha;
	private @NotNull LocalDateTime instanteCriacao = LocalDateTime.now();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Deprecated
	public Usuario() {
	}

	public Usuario(@Email @NotBlank String email,
			@Valid @NotNull SenhaLimpa senhaLimpa) {
		Assert.isTrue(StringUtils.hasLength(email),"email não pode ser em branco");
		Assert.notNull(senhaLimpa,"o objeto do tipo senha limpa nao pode ser nulo");	
		
		this.email = email;
		this.senha = senhaLimpa.hash();
		this.instanteCriacao = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", senha=" + senha
				+ "]";
	}
}
