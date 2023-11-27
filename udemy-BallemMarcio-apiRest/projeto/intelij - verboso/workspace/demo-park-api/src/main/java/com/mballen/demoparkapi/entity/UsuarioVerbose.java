package com.mballen.demoparkapi.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/*VERSÃO VERBOSA, ALTAMENTE COMENTADA PRA FINS DIDÁTICOS E SEM O LONBOK
Fazendo o mapeamento da Entidade usuarios. (Mapeamento para o banco de dados)*/
@Entity
@Table(name = "usuarios")
public class UsuarioVerbose implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="username", nullable = false, unique = true, length = 100)
    private String username;

    //Como o password será criptografado o tamanho do campo ficou maior para suportar o tamanho da criptografia
    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @Enumerated(EnumType.STRING) // Converte Role em String
    //Quando é String ele transforma o nome da constante numa String pra salvar no banco de dados.
    // Ordinal leva em consideração a posição da constante no banco.
    @Column(name = "role", nullable = false, length = 25)
    // Para perfis de usuário (adm e cliente)
    private Role role;

    @Column(name = "data_criacao")
    // Para auditoria
    private LocalDateTime dataCriacao;

    @Column(name = "data_modificacao")
    private LocalDateTime dataModificacao;

    @Column(name = "criado_por")
    private String criadoPor;

    @Column(name = "modificado_por")
    private String modificadoPor;


    public enum Role{
        ROLE_ADMIN, ROLE_CLIENTE

        // Essas constantes são para cada um dos perfis.
        // Elas naturalmente são representadas por 0 e 1, que são os seus indexs, mas
        // para facilitar a sua leitura, o atributo role foi convertido em String.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioVerbose usuario = (UsuarioVerbose) o;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public String getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(String criadoPor) {
        this.criadoPor = criadoPor;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }
}
