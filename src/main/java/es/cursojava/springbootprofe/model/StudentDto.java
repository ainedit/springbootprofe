package es.cursojava.springbootprofe.model;

public class StudentDto {
	private Long id;
    private String nombre;
    private String email;
    private Integer edad;
    private String curso;

    public StudentDto() {}

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

}
