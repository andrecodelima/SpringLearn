package com.mballem.demoparkapi.entity;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
=======

>>>>>>> 7e3761687b2b9eefe8487a6b1ba97460f1cb9813
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    @Column(name = "password", nullable = false, length = 200)
    private String password;

<<<<<<< HEAD
    @Enumerated(EnumType.STRING)
=======
>>>>>>> 7e3761687b2b9eefe8487a6b1ba97460f1cb9813
    @Column(name = "role", nullable = false, length = 25)
    private Role role;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_modificacao")
    private LocalDateTime dataModificacao;

    @Column(name = "criado_por")
    private String criadoPor;

    @Column(name = "modificado_Por")
    private String modificadoPor;

    public enum Role{
        ROLE_ADMIN, ROLE_CLIENTE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                '}';
    }
<<<<<<< HEAD


=======
>>>>>>> 7e3761687b2b9eefe8487a6b1ba97460f1cb9813
}
