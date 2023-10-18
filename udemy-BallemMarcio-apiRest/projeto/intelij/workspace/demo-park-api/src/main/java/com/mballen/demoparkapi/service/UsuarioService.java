package com.mballen.demoparkapi.service;

import com.mballen.demoparkapi.entity.Usuario;
import com.mballen.demoparkapi.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    /* Spring vai tomar conta da parte referente a transação. É ele que vai cuidar do recurso
    para abrir, gerenciar e fechar a transação do método 'save'*/
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id) {

        /* Foi usado um método que já existia dentro do spring (findById)
           junto com ele, usamos o metodo 'orElseThrow' que retorna um usuario
           ou lança uma exceção.
        * */
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );
    }
}
