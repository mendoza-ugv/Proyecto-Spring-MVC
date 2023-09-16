package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "domicilio")
public class Domicilio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdDomicilio;
	
	@Column(name = "ciudad", length = 50) 
	private String ciudad;
	
	@Column(name = "colonia", length = 50) 
	private String colonia;
	
	@Column(name = "calle", length = 50)
	private String calle;

	public Domicilio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Domicilio(int idDomicilio, String ciudad, String colonia, String calle) {
		super();
		IdDomicilio = idDomicilio;
		this.ciudad = ciudad;
		this.colonia = colonia;
		this.calle = calle;
	}

	public int getIdDomicilio() {
		return IdDomicilio;
	}

	public void setIdDomicilio(int idDomicilio) {
		IdDomicilio = idDomicilio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

}
