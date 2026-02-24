package com.example.ADDHuerta;

import com.example.ADDHuerta.dominio.*;
import com.example.ADDHuerta.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddHuertaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddHuertaApplication.class, args);
	}

	@Bean
	CommandLineRunner probar(HuertoRepo huertoRepo,
							 PersonaRepo personaRepo,
							 LaborRepo laborRepo) {

		return args -> {


			Persona persona = new Persona("Juan", "Pérez");
			personaRepo.save(persona);


			Huerto huerto = new Huerto("Tomates", "Valencia", persona, Tamanio.GRANDE);
			huertoRepo.save(huerto);


			Labor labor = new Labor("Regar", "2026-03-01", huerto);
			laborRepo.save(labor);


			System.out.println("PERSONAS:");
			personaRepo.findAll().forEach(System.out::println);

			System.out.println("HUERTOS:");
			huertoRepo.findAll().forEach(System.out::println);

			System.out.println("LABORES:");
			laborRepo.findAll().forEach(System.out::println);
		};
	}
}