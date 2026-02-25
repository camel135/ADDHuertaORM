package com.example.ADDHuerta;

import com.example.ADDHuerta.dominio.Persona;
import com.example.ADDHuerta.dominio.Tamanio;
import com.example.ADDHuerta.dominio.Huerto;
import com.example.ADDHuerta.repository.PersonaRepo;
import com.example.ADDHuerta.service.HuertoService;
import com.example.ADDHuerta.service.LaborService;
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
	CommandLineRunner probar(PersonaRepo personaRepo,
							 HuertoService huertoService,
							 LaborService laborService) {

		return args -> {

			Persona p = personaRepo.save(new Persona("Juan", "Perez"));

			Tamanio t = new Tamanio(120, "m2");

			Huerto h = huertoService.crearHuerto(
					"Tomates",
					"Valencia",
					t,
					p.getId()
			);

			laborService.crearLabor("Regar", "2026-03-01", h.getId());

			huertoService.listar().forEach(System.out::println);
		};
	}
}