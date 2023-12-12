package com.mballen.demoparkapi.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

// Para que essa classe seja uma classe de configuração usamos a anotação 'configuration'
@Configuration
public class SpringTimeZoneConfig {

    /* PostConstruct -> Após a classe ser inicializada pelo spring, o método construtor dela é executado.
    E após a execução do método construtor, o primeiro método que vai ser executado é o timezoneConfig.
    */
    @PostConstruct
    public void timezoneConfig(){
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }
}
