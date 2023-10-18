package com.mballen.demoparkapi.repository;

import com.mballen.demoparkapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// Essa interface fornece vários métodos prontos onde só passamos o parâmetro
public interface UsuarioRepositoryVerbose extends JpaRepository<Usuario, Long> {

}
