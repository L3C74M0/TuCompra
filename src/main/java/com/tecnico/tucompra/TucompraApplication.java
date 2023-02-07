package com.tecnico.tucompra;

import java.util.Date;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.tecnico.tucompra.model.Colaborador;
import com.tecnico.tucompra.model.Detalle_Historia_Clinica;
import com.tecnico.tucompra.model.Historia_Clinica;
import com.tecnico.tucompra.model.Mascota;
import com.tecnico.tucompra.model.Usuario;
import com.tecnico.tucompra.service.Colaborador_Service;
import com.tecnico.tucompra.service.Detalle_Historia_Clinica_Service;
import com.tecnico.tucompra.service.Historia_Clinica_Service;
import com.tecnico.tucompra.service.Mascota_Service;
import com.tecnico.tucompra.service.Usuario_Service;

@SpringBootApplication
public class TucompraApplication {

	public static void main(String[] args) {
		SpringApplication.run(TucompraApplication.class, args);
	}

	@Bean
	public CommandLineRunner dummy(Usuario_Service usuariorService, Mascota_Service mascotaService,
			Historia_Clinica_Service historiaService, Detalle_Historia_Clinica_Service detalleService,
			Colaborador_Service colaborador_Service) {
		return (args) -> {
			Mascota mst = new Mascota();
			mst.setId(0);
			mst.setNombre("Le Tongue");
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
			usuariorService.save(usr);

			Historia_Clinica hst = new Historia_Clinica();
			hst.setId(0);
			hst.setFecha_creacion(0101202);
			historiaService.save(hst);

			Colaborador clb = new Colaborador();
			clb.setId(0);
			clb.setNombre("Carlos");
			clb.setApellido("restrepo");
			clb.setCargo("Veterinario");
			clb.setEspecialidad("Radiologia");
			clb.setTipo_documento("CC");
			clb.setDocumento_identificacion(23213);
			colaborador_Service.save(clb);

			Detalle_Historia_Clinica detalle = new Detalle_Historia_Clinica();
			detalle.setId(0);
			detalle.setTemperatura("normal");
			detalle.setPeso(36.0);
			detalle.setFrecuencia_cardiaca(10.0);
			detalle.setFrecuencia_respiratoria(10.0);
			detalle.setFecha_hora(new Date());
			detalle.setAlimentacion("Pedigree");
			detalle.setHabitad("Domestico");
			detalle.setObservacion("Todo esta normal");
			detalle.setHistoria_clinica(hst);
			detalleService.save(detalle);
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
