package es.cursojava.springbootprofe.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class StudentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // En Oracle a veces se usa SEQUENCE
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(unique = true)
  private String email;
  
  @Column(nullable = false)
  private int edad;
  
  @Column
  private String curso;

  public StudentEntity() {}

  public StudentEntity(String name, String email) {
    this.name = name;
    this.email = email;
  }
  
  public StudentEntity(Long id, String name, String email, int edad, String curso) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.edad = edad;
	this.curso = curso;
}

  public Long getId() {
	return id;
  }

  public void setId(Long id) {
	this.id = id;
  }

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public String getEmail() {
	return email;
  }

  public void setEmail(String email) {
	this.email = email;
  }

  public int getEdad() {
	return edad;
  }

  public void setEdad(int edad) {
	this.edad = edad;
  }

  public String getCurso() {
	return curso;
  }

  public void setCurso(String curso) {
	this.curso = curso;
  }
  
}
