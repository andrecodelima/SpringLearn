package com.mballem.demoparkapi.web.controller;

import com.mballem.demoparkapi.entity.Usuario;
import com.mballem.demoparkapi.service.UsuarioService;
import com.mballem.demoparkapi.web.dto.UsuarioCreateDTO;
import com.mballem.demoparkapi.web.dto.UsuarioResponseDTO;
<<<<<<< HEAD
<<<<<<< HEAD
import com.mballem.demoparkapi.web.dto.UsuarioSenhaDTO;
import com.mballem.demoparkapi.web.dto.mapper.UsuarioMapper;
import jakarta.validation.Valid;
=======
import com.mballem.demoparkapi.web.dto.mapper.UsuarioMapper;
>>>>>>> 3bcf8bd001d2fb44e4b3d3e67be2aa44c3aa0d7c
=======
import com.mballem.demoparkapi.web.dto.UsuarioSenhaDTO;
import com.mballem.demoparkapi.web.dto.mapper.UsuarioMapper;
import jakarta.validation.Valid;
>>>>>>> 5994e040a1a3a780c6c8cc943670b2a6bb1c5e06
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    //Inserindo usuário
    @PostMapping
<<<<<<< HEAD
<<<<<<< HEAD
    public ResponseEntity<UsuarioResponseDTO> create(@Valid @RequestBody UsuarioCreateDTO createDTO){
=======
    public ResponseEntity<UsuarioResponseDTO> create(@RequestBody UsuarioCreateDTO createDTO){
>>>>>>> 3bcf8bd001d2fb44e4b3d3e67be2aa44c3aa0d7c
       Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(createDTO));
       return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));

=======
    public ResponseEntity<UsuarioResponseDTO> create(@Valid @RequestBody UsuarioCreateDTO createDto) {
        Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
>>>>>>> 5994e040a1a3a780c6c8cc943670b2a6bb1c5e06
    }

    //Localizando um usuário
    @GetMapping("/{id}")
<<<<<<< HEAD
<<<<<<< HEAD
    public ResponseEntity<UsuarioResponseDTO> getById(@PathVariable Long id){
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
=======
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(user);
>>>>>>> 3bcf8bd001d2fb44e4b3d3e67be2aa44c3aa0d7c
=======
    public ResponseEntity<UsuarioResponseDTO> getById(@PathVariable Long id) {
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
>>>>>>> 5994e040a1a3a780c6c8cc943670b2a6bb1c5e06
    }


    //Alterando a senha
    @PatchMapping("/{id}")
<<<<<<< HEAD
<<<<<<< HEAD
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody UsuarioSenhaDTO dto){
        Usuario user = usuarioService.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfirmaSenha());
        return ResponseEntity.noContent().build();
    }


    //Listar todos os usuários
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> getAll(){
        List<Usuario> users = usuarioService.buscarTodos();
        return ResponseEntity.ok(UsuarioMapper.toListDTO(users));
=======
    public ResponseEntity<Usuario> updatePassword(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario user = usuarioService.editarSenha(id, usuario.getPassword());
        return ResponseEntity.ok(user);
=======
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody UsuarioSenhaDTO dto){
        Usuario user = usuarioService.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfirmaSenha());
        return ResponseEntity.noContent().build();
>>>>>>> 5994e040a1a3a780c6c8cc943670b2a6bb1c5e06
    }


    //Listar todos os usuários
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> getAll() {
        List<Usuario> users = usuarioService.buscarTodos();
<<<<<<< HEAD
        return ResponseEntity.ok(users);
>>>>>>> 3bcf8bd001d2fb44e4b3d3e67be2aa44c3aa0d7c
=======
        return ResponseEntity.ok(UsuarioMapper.toListDTO(users));
>>>>>>> 5994e040a1a3a780c6c8cc943670b2a6bb1c5e06
    }




}
