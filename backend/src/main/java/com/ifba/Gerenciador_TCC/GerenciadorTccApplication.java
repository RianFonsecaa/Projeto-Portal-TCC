package com.ifba.Gerenciador_TCC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class GerenciadorTccApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorTccApplication.class, args);
	}

}
