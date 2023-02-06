package com.tecnico.tucompra.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.NonNull;

@Entity
@Table (name = "Colaborador") 
public class Colaborador {

	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NonNull
	private String nombre;

	@NonNull
	private String apellido;

	@NonNull
	private String cargo;

	@NonNull
	private String especialidad;

	@NonNull
	private String tipo_documento;

	@NonNull
	private int documento_identificacion;

	@OneToOne
	private Detalle_Historia_Clinica detalle_Historia_Clinica;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public int getDocumento_identificacion() {
		return documento_identificacion;
	}

	public void setDocumento_identificacion(int documento_identificacion) {
		this.documento_identificacion = documento_identificacion;
	}

	public Detalle_Historia_Clinica getDetalle_Historia_Clinica() {
		return detalle_Historia_Clinica;
	}

	public void setDetalle_Historia_Clinica(Detalle_Historia_Clinica detalle_Historia_Clinica) {
		this.detalle_Historia_Clinica = detalle_Historia_Clinica;
	}
}
