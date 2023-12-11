package com.mballem.demoparkapi.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioCreateDTO {

    @NotBlank
    @Email(message = "Formato do e-mail está inválido", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
    //tratando formato do email por email de expressão regular - regexp
    private String username;

    @NotBlank
    @Size(min = 6, max = 6)
    private String password;
}

