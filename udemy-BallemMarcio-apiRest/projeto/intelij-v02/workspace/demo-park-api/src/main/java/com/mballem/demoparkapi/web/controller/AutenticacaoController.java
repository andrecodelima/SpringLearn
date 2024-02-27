package com.mballem.demoparkapi.web.controller;

import com.mballem.demoparkapi.jwt.JwtToken;
import com.mballem.demoparkapi.jwt.JwtUserDetailsService;
import com.mballem.demoparkapi.web.dto.UsuarioLoginDto;
import com.mballem.demoparkapi.web.exception.ErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AutenticacaoController {

    private final JwtUserDetailsService detailsService;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/auth")
    public ResponseEntity<?> autenticar(@RequestBody @Valid UsuarioLoginDto dto, HttpServletRequest request){
        log.info("Processo de autenticação pelo login{}", dto.getUsername());

        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
            authenticationManager.authenticate(authenticationToken);
            JwtToken token = detailsService.getTokenAuthenticated(dto.getUsername());
            return ResponseEntity.ok(token);

        }catch (AuthenticationException ex){
            log.warn("Bad Credentials from usarname '{}", dto.getUsername());
        }
        return ResponseEntity
                .badRequest()
                .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, "Credenciais inválidas"));

    }
}

/*
* RESUMO
* O Usuario vai enviar uma requisição de autenticação. Essa requisição vai conter o username e o password.
* Vamos recuperar esses valores e passar para a classe 'UsernamePasswordAuthenticationToken'.
* Essa classe vai pegar esse usuario e senha e vai verificar no banco de dados se existe um usuario com essa senha.
* Se existir, ela retorna o objeto 'AuthenticationToken' e a gente adiciona esse objeto como parte do contexto de autenticação do Spring.
* Se esse processo gerar uma exceção, iremos cair no 'cath' e depois no 'bad request'.
*
* Se não gerar uma exceção, iremos para o 'JWT Token' onde iremos gerar o token a apartir  do usuario e depois responder essa requisição
* com o token gerado.
*
* */