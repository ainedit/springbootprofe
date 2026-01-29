package es.cursojava.springbootprofe.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CABALLO")
public class CaballoEntity {
	// nombre,edad,dorsal,peso,velocidad,experiencia
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "edad", nullable = false)
	private int edad;

	@Column(name = "dorsal", nullable = false)
	private int dorsal;
	
	@Column(name = "peso", nullable = false)
	private double peso;
	
	@Column(name = "velocidad", nullable = false)
	private double velocidad;
	
	@Column(name = "experiencia", nullable = false)
	private int experiencia;
	
	
	public CaballoEntity() {
		
	}
	
	public CaballoEntity(Long id, String nombre, int edad, int dorsal, double peso, double velocidad,
			int experiencia) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.dorsal = dorsal;
		this.peso = peso;
		this.velocidad = velocidad;
		this.experiencia = experiencia;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	public int getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	
	@Override
	public String toString() {
		return "CaballoEntity [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", dorsal=" + dorsal + ", peso="
				+ peso + ", velocidad=" + velocidad + ", experiencia=" + experiencia + "]";
	}
	

}
