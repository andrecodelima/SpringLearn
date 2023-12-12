package com.mballem.demoparkapi.web.dto;

<<<<<<< HEAD
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
=======
>>>>>>> 3bcf8bd001d2fb44e4b3d3e67be2aa44c3aa0d7c
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioCreateDTO {

<<<<<<< HEAD
    @NotBlank
    @Email(message = "Formato do e-mail está inválido", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
    //tratando formato do email por email de expressão regular - regexp
    private String username;

    @NotBlank
    @Size(min = 6, max = 6)
=======
    private String username;
>>>>>>> 3bcf8bd001d2fb44e4b3d3e67be2aa44c3aa0d7c
    private String password;
}

