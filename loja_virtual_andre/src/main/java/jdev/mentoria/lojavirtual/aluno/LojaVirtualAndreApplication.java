package jdev.mentoria.lojavirtual.aluno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LojaVirtualAndreApplication {

	public static void main(String[] args) {
		
//		System.out.println(new BCryptPasswordEncoder().encode("123"));//
		SpringApplication.run(LojaVirtualAndreApplication.class, args);
	}

}
