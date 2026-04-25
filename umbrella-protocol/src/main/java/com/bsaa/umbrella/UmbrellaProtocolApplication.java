package com.bsaa.umbrella;

import com.bsaa.umbrella.controller.BOWController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class UmbrellaProtocolApplication {

    public static void main(String[] args) {
        System.out.println("Iniciando Sistema B.S.A.A. - Protocolo de Contención Umbrella...\n");
        SpringApplication.run(UmbrellaProtocolApplication.class, args);
    }

    @Bean
    public CommandLineRunner ejecutarProtocolo(BOWController bowController) {
        return args -> {
            bowController.ejecutarProtocoloContencion();
        };
    }
}
