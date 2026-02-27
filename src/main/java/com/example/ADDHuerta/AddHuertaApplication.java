package com.example.ADDHuerta;

import com.example.ADDHuerta.dominio.Huerto;
import com.example.ADDHuerta.dominio.Persona;
import com.example.ADDHuerta.dominio.Tamanio;
import com.example.ADDHuerta.service.HuertoService;
import com.example.ADDHuerta.service.LaborService;
import com.example.ADDHuerta.service.PersonaService;
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
	CommandLineRunner probar(PersonaService personaService,
							 HuertoService huertoService,
							 LaborService laborService) {
		return args -> {
			// Guardar persona mediante Servicio
			Persona p = personaService.guardar("Juan", "Perez");

			// Crear huerto con objeto valor
			Tamanio t = new Tamanio(120, "m2");
			Huerto h = huertoService.crearHuerto("Tomates", "Valencia", t, p.getId());

			// Uso de SETTER para demostrar funcionalidad
			h.setLocalizacion("Valencia Norte");
			huertoService.crearHuerto(h.getCultivo(), h.getLocalizacion(), h.getTamanio(), p.getId());

			// Crear labor
			laborService.crearLabor("Regar", "2026-03-01", h.getId());

			System.out.println("--- LISTADO DE HUERTOS ---");
			huertoService.listar().forEach(System.out::println);

			// Uso de GETTER para consola
			System.out.println("Dueño del primer huerto: " + p.getNombre());
		};
	}
}