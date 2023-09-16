package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "ciudadano")
public class Ciudadano {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdCiudadano;
	
	@Column(name = "nombre", length = 50) 
	private String nombre;
	
	@Column(name = "edad") 
	private int edad;
	
	@Column(name = "telefono") 
	private String telefono;
	
	public Ciudadano() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ciudadano(int idCiudadano, String nombre, int edad, String telefono) {
		super();
		IdCiudadano = idCiudadano;
		this.nombre = nombre;
		this.edad = edad;
		this.telefono = telefono;
	}

	public int getIdCiudadano() {
		return IdCiudadano;
	}
	
	public void setIdCiudadano(int idCiudadano) {
		IdCiudadano = idCiudadano;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
