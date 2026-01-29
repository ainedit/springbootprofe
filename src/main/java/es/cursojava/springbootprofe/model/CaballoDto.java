package es.cursojava.springbootprofe.model;

public class CaballoDto {
	private Long id;
	private String nombre;
	private int edad;
	private int dorsal;
	private double peso;
	private double velocidad;
	private int experiencia;

	// Constructor vacío (necesario para Thymeleaf)
	public CaballoDto() {

	}

	// Constructor con todos los atributos

	public CaballoDto(Long id, String nombre, int edad, int dorsal, double peso, double velocidad,
			int experiencia) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.dorsal = dorsal;
		this.peso = peso;
		this.velocidad = velocidad;
		this.experiencia = experiencia;
	}
	
	//contructor con atributos para ganador id internamente y nombre vista o para pasarselo al mapper
	public CaballoDto(Long id,String nombre) {
		this.id=id;
		this.nombre=nombre;
	}
	// Getters y Setters

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
	
	public String toString() {
		return "CaballoDto [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", dorsal=" + dorsal + ", peso="
				+ peso + ", velocidad=" + velocidad + ", experiencia=" + experiencia + "]";
	}
	

}
