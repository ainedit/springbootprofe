package es.cursojava.springbootprofe.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Datos de un alumno")
public class StudentDto {
	@Schema(description = "Identificador del alumno", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
	private Long id;

	@NotBlank
	@Schema(description = "Nombre del alumno", example = "Marina")
	private String nombre;

	@Schema(description = "Email del alumno", example = "ejemplo@ejemplo.com")
	private String email;

	@Min(0)
	@Schema(description = "Edad del alumno", example = "18")
	private Integer edad;

	@Schema(description = "Curso del alumno", example = "Primero de la ESO")
	private String curso;

	public StudentDto() {
	}

	public StudentDto(Long id, String nombre, String email, int edad, String curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
		this.curso = curso;
	}

	public StudentDto(String nombre, String email, Integer edad, String curso) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
		this.curso = curso;
	}

	public StudentDto(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	}

	public StudentDto(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
