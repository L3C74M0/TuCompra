package com.tecnico.tucompra.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.NonNull;

@Entity
@Table (name = "Detalle_Historia_Clinica") 
public class Detalle_Historia_Clinica {

	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DETALLE_ID")
	private int id;

	@NonNull
	@Column(name = "DETALLE_TEMPERATURA")
	private String temperatura;

	@NonNull
	@Column(name = "DETALLE_PESO")
	private double peso;

	@NonNull
	@Column(name = "DETALLE_FRECUENCIA_CARDIACA")
	private double frecuencia_cardiaca;

	@NonNull
	@Column(name = "DETALLE_FRECUENCIA_RESPIRATORIA")
	private double frecuencia_respiratoria;

	@NonNull
	@Column(name = "DETALLE_FECHA")
	private Date fecha_hora;

	@NonNull
	@Column(name = "DETALLE_ALIMENTACION")
	private String alimentacion;

	@NonNull
	@Column(name = "DETALLE_HABITAD")
	private String habitad;

	@NonNull
	@Column(name = "DETALLE_OBSERVACION")
	private String observacion;

	@OneToOne
	private Colaborador colaborador;

	@ManyToOne
	@NonNull
	@JoinColumn (name = "DTLE_HISTORIA_ID")
	private Historia_Clinica historia_clinica;

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getFrecuencia_cardiaca() {
		return frecuencia_cardiaca;
	}

	public void setFrecuencia_cardiaca(double frecuencia_cardiaca) {
		this.frecuencia_cardiaca = frecuencia_cardiaca;
	}

	public double getFrecuencia_respiratoria() {
		return frecuencia_respiratoria;
	}

	public void setFrecuencia_respiratoria(double frecuencia_respiratoria) {
		this.frecuencia_respiratoria = frecuencia_respiratoria;
	}

	public Date getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public String getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}

	public String getHabitad() {
		return habitad;
	}

	public void setHabitad(String habitad) {
		this.habitad = habitad;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Historia_Clinica getHistoria_clinica() {
		return historia_clinica;
	}

	public void setHistoria_clinica(Historia_Clinica historia_clinica) {
		this.historia_clinica = historia_clinica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
