package com.tecnico.tucompra;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tecnico.tucompra.model.Mascota;
import com.tecnico.tucompra.model.Usuario;
import com.tecnico.tucompra.service.Mascota_Service;
import com.tecnico.tucompra.service.Usuario_Service;

@SpringBootApplication
public class TucompraApplication {

	public static void main(String[] args) {
		SpringApplication.run(TucompraApplication.class, args);
	}

	@Bean
	public CommandLineRunner dummy(Usuario_Service usuariorService, Mascota_Service mascotaService) {
		return (args) -> {
			Mascota mst = new Mascota();
			mst.setId(0);
			mst.setNombre("Lazzie");
			mst.setRaza("Pastor");
			mst.setSexo('F');
			mascotaService.save(mst);

			Usuario usr = new Usuario();
			usr.setId(0);
			usr.setNombre("Lewis");
			usr.setApellido("Hamilton");
			usr.setTipo_documento('C');
			usr.setDocumento_identificacion(1234567890);
			usr.setEstado('C');
			usr.setSexo('M');
			usr.addMascota(mst);
			usuariorService.save(usr);
		};
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("*")
						.allowedHeaders("*");
			}
		};
	}
}
