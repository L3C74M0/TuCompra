package com.tecnico.tucompra.model;

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
@Table (name = "Mascota")
public class Mascota {

	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MASCOTA_ID")
	private int id;

	@NonNull
	@Column(name = "MASCOTA_NOMBRE")
	private String nombre;

	@NonNull
	@Column(name = "MASCOTA_RAZA")
	private String raza;

	@ManyToOne
	@NonNull
	@JoinColumn (name = "USR_USUARIO_ID")
	private Usuario usuario;

	@NonNull
	@Column(name = "MASCOTA_SEXO")
	private char sexo;

	@OneToOne
	private Historia_Clinica historia_clinica;

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

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
}
