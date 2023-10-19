package com.mballen.demoparkapi.service;

import com.mballen.demoparkapi.entity.Usuario;
import com.mballen.demoparkapi.entity.UsuarioVerbose;
import com.mballen.demoparkapi.repository.UsuarioRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    /* Spring vai tomar conta da parte referente a transação. É ele que vai cuidar do recurso
    para abrir, gerenciar e fechar a transação do método 'save'*/
    public UsuarioVerbose salvar(UsuarioVerbose usuario) {
        return usuarioRepository.save(usuario);
    }


    @Transactional(readOnly = true)
    /* Incluída a propriedade 'readOnly'.
     *  Com essa propriedade o Spring sabe exatamente qual tipo de transaão ele precisa utilizar, já que
     * é um método apenas de consulta. Isso dá uma melhor performace as aplicações.
     * */
    public UsuarioVerbose buscarPorId(Long id) {

        /* Foi usado um método que já existia dentro do spring (findById)
           junto com ele, usamos o metodo 'orElseThrow' que retorna um usuario
           ou lança uma exceção.
        * */
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );
    }
}
