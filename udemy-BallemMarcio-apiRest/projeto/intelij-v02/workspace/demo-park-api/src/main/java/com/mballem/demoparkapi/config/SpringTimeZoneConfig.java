package com.mballem.demoparkapi.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;


@Configuration
public class SpringTimeZoneConfig {
//Classe de configuração, por isso a anotação 'configuration'

    //Metodo para definir o TimeZone
    @PostConstruct
    public void timezoneConfig(){
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }
}
