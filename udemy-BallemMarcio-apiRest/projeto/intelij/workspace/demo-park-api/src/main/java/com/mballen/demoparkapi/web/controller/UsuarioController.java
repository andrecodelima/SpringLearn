package com.mballen.demoparkapi.web.controller;

import com.mballen.demoparkapi.entity.Usuario;
import com.mballen.demoparkapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping // Para inserir
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        Usuario user = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}") // Para recuperar um valor
    /*Id vai ser enviado como um parametro, mas como um parametro de caminho (Path Paramt)
    * {} o par de chaves indica que há um valor que será enviado aqui.
    * @PathVariable - Pega esse valor e adiciona ele numa variavel do tipo Long
    * */

    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
