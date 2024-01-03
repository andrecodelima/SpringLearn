package com.mballem.demoparkapi.service;

import com.mballem.demoparkapi.entity.Usuario;
import com.mballem.demoparkapi.exception.UsernameUniqueViolationException;
import com.mballem.demoparkapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (org.springframework.dao.DataIntegrityViolationException ex){
            throw new UsernameUniqueViolationException(String.format("Username {%s} já cadastrado", usuario.getUsername()));
        }

    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado.")
        );
    }

    @Transactional
<<<<<<< HEAD
<<<<<<< HEAD
    public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {

        if(!novaSenha.equals(confirmaSenha)){
            throw new RuntimeException("As senhas não são iguais");
        }

        Usuario user = buscarPorId(id);
        if(!user.getPassword().equals(senhaAtual)){
            throw new RuntimeException("A senha está incorreta");
        }

        user.setPassword(novaSenha);
=======
    public Usuario editarSenha(Long id, String password) {
        Usuario user = buscarPorId(id);
        user.setPassword(password);
>>>>>>> 3bcf8bd001d2fb44e4b3d3e67be2aa44c3aa0d7c
=======
    public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
        if (!novaSenha.equals(confirmaSenha)) {
            throw new RuntimeException("Nova senha não confere com confirmação de senha.");
        }

        Usuario user = buscarPorId(id);
        if (!user.getPassword().equals(senhaAtual)) {
            throw new RuntimeException("Sua senha não confere.");
        }

        user.setPassword(novaSenha);
>>>>>>> 5994e040a1a3a780c6c8cc943670b2a6bb1c5e06
        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}

// ==== NOTAS
/*
    ========== UsuarioRepository =============

* Ao invés de criar o método save dentro da classe UsuarioService,
* esse método é IMPORTADO da 'classe' 'UsuarioRepository'
* que extende a interface JpaRepository que FORNECE METODOS ADICIONAIS
* para operações comuns de banco de dados, como salvar, excluir e atualizar objetos.
*
*
 */