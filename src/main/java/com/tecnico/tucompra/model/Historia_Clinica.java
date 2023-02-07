package com.tecnico.tucompra.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
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
	@Column(name = "HISTORIA_ID")
	private int id;

	@OneToOne
	@NonNull
	private Mascota mascota;

	@NonNull
	@Column(name = "HISTORIA_FECHA")
	private int fecha_creacion;

	@OneToMany
	private List<Detalle_Historia_Clinica> detalles = new ArrayList<Detalle_Historia_Clinica>();

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
}
