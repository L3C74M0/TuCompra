package com.tecnico.tucompra.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NonNull;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USUARIO_ID")
	private int id;

	@NonNull
	@Column(name = "USUARIO_NOMBRE")
	private String nombre;

	@NonNull
	@Column(name = "USUARIO_APELLIDO")
	private String apellido;

	@NonNull
	@Column(name = "USUARIO_TIPODOCUMENTO")
	private char tipo_documento;

	@NonNull
	@Column(unique = true, name = "USUARIO_DOCUMENTO")
	private int documento_identificacion;

	@NonNull
	@Column(name = "USUARIO_ESTADO")
	private char estado;

	@NonNull
	@Column(name = "USUARIO_SEXO")
	private int sexo;

	@OneToMany
	private List<Mascota> mascotas = new ArrayList<Mascota>();

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

	public char getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(char tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public int getDocumento_identificacion() {
		return documento_identificacion;
	}

	public void setDocumento_identificacion(int documento_identificacion) {
		this.documento_identificacion = documento_identificacion;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public Mascota addMascota(Mascota mascota) {
		getMascotas().add(mascota);
		mascota.setUsuario(this);

		return mascota;
	}

	public Mascota removeMascota(Mascota mascota) {
		getMascotas().remove(mascota);
		mascota.setUsuario(null);

		return mascota;
	}
}
