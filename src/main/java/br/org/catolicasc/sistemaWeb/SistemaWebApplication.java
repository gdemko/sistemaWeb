package br.org.catolicasc.sistemaWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.org.catolicasc.sistemaWeb", "controller"})
public class SistemaWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(SistemaWebApplication.class, args);
	}	
}