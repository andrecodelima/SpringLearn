package com.mballem.demoparkapi.jwt;

import com.mballem.demoparkapi.entity.Usuario;
import com.mballem.demoparkapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UsuarioService usuarioService;

    //Irá conferir se a senha enviada na requisição é igual a senha no banco de dados.
    @Override
    public UserDetails loadUserByUsername(String username){
        Usuario usuario = usuarioService.buscaPorUsername(username);
        return new JwtUserDatails(usuario);
    }

    // Gerar o Token JWT
    public JwtToken getTokenAuthenticated(String username){
        Usuario.Role role = usuarioService.buscaRolePorUsername(username);
        return JwtUtils.createToken(username, role.name().substring("ROLE".length()));

    }
}
