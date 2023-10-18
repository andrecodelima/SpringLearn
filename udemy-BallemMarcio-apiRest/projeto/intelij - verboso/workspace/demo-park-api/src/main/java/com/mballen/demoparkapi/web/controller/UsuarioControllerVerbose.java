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
// Spring entende que essa classe é um Bin gerenciado por ele e é um Bin do tipo Controller
@RestController

//Caminho base dos recursos (Path de acesso ao recurso)
@RequestMapping("api/v1/usuarios")
/*  api         - normalmente as APIs levam esse nome como parte da url de acesso ao recurso
    v1          - versão da API
    usuarios    - Nome do recurso (Sempre no plural)
*/
public class UsuarioControllerVerbose {

    // Colocando a injeção de dependencias
    private final UsuarioService usuarioService;

    // Metodo especifico do Spring para trabalhar com Rest - ResponseEntity
    /*  Objetivo:  Encapsular a resposta, que nesse caso será um objeto 'usuario'
        que será transformado num JSON e será enviado ao cliente.
        Junto com o objeto, o ResponseEntity guarda outras informações como por exemplo o código
        de resposta e o cabeçalho.
    */

    @PostMapping
    public ResponseEntity<Usuario> create (Usuario usuario){
        Usuario user = usuarioService.salvar(usuario);

        // Retornando uma resposta ao cliente
        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }
}
