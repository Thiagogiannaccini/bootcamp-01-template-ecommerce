package com.mercadolivre.mercadolivre.Seguranca;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;

import com.mercadolivre.mercadolivre.UsuarioLogado;
import com.mercadolivre.mercadolivre.Usuario.Usuario;

@Configuration
public class AppUserDetailsMapper implements UserDetailsMapper {
    @Override
    public UserDetails map(Object shouldBeASystemUser) {
        return new UsuarioLogado((Usuario) shouldBeASystemUser);
    }
}