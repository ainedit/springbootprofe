package es.cursojava.springbootprofe.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cursojava.springbootprofe.entities.StudentEntity;
import es.cursojava.springbootprofe.model.StudentDto;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
	  Optional<StudentDto> findByEmail(String email);

}
