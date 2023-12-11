package com.mballem.demoparkapi.service;

import com.mballem.demoparkapi.entity.Usuario;
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
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado.")
        );
    }

    @Transactional
    public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {

        if(!novaSenha.equals(confirmaSenha)){
            throw new RuntimeException("As senhas não são iguais");
        }

        Usuario user = buscarPorId(id);
        if(!user.getPassword().equals(senhaAtual)){
            throw new RuntimeException("A senha está incorreta");
        }

        user.setPassword(novaSenha);
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