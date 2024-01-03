package com.mballem.demoparkapi.web.dto;

<<<<<<< HEAD
<<<<<<< HEAD
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
=======
>>>>>>> 3bcf8bd001d2fb44e4b3d3e67be2aa44c3aa0d7c
=======
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

>>>>>>> 5994e040a1a3a780c6c8cc943670b2a6bb1c5e06
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioCreateDTO {

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 5994e040a1a3a780c6c8cc943670b2a6bb1c5e06
    @NotBlank
    @Email(message = "Formato do e-mail está inválido", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
    //tratando formato do email por email de expressão regular - regexp
    private String username;

    @NotBlank
    @Size(min = 6, max = 6)
<<<<<<< HEAD
=======
    private String username;
>>>>>>> 3bcf8bd001d2fb44e4b3d3e67be2aa44c3aa0d7c
=======
>>>>>>> 5994e040a1a3a780c6c8cc943670b2a6bb1c5e06
    private String password;
}

