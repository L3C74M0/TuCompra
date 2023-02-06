package com.tecnico.tucompra.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.NonNull;

@Entity
@Table(name = "Historia_Clinica")
public class Historia_Clinica {

	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	@NonNull
	private Mascota mascota;

	@NonNull
	private int fecha_creacion;

	@OneToMany
	private List<Detalle_Historia_Clinica> detalles;

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public int getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(int fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public List<Detalle_Historia_Clinica> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle_Historia_Clinica> detalles) {
		this.detalles = detalles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Detalle_Historia_Clinica addDetalle_Historia_Clinica(Detalle_Historia_Clinica detalle_Historia_Clinica) {
		getDetalles().add(detalle_Historia_Clinica);
		detalle_Historia_Clinica.setHistoria_clinica(this);
		
		return detalle_Historia_Clinica;
	}
	
	public Detalle_Historia_Clinica removeDetalle_Historia_Clinica(Detalle_Historia_Clinica detalle_Historia_Clinica) {
		getDetalles().remove(detalle_Historia_Clinica);
		detalle_Historia_Clinica.setHistoria_clinica(null);
		
		return detalle_Historia_Clinica;
	}
}
