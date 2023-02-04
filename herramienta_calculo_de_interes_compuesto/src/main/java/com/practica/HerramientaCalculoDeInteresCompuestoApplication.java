package com.practica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controllers","model","service"})
public class HerramientaCalculoDeInteresCompuestoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HerramientaCalculoDeInteresCompuestoApplication.class, args);
	}

}
