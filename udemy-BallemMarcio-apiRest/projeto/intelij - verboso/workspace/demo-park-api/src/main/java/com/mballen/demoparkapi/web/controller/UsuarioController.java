package com.mballen.demoparkapi.web.controller;

import com.mballen.demoparkapi.entity.Usuario;
import com.mballen.demoparkapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")

public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> create (Usuario usuario){
        Usuario user = usuarioService.salvar(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }
}
