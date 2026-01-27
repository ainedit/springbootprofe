package es.cursojava.springbootprofe.services;

import org.springframework.stereotype.Service;

import es.cursojava.springbootprofe.entities.StudentEntity;
import es.cursojava.springbootprofe.mapper.StudentMapper;
import es.cursojava.springbootprofe.model.StudentDto;
import es.cursojava.springbootprofe.repositories.StudentRepository;
import jakarta.transaction.Transactional;

@Service
public class StudentService {

  private final StudentRepository repo;
  private final StudentMapper mapper;

  public StudentService(StudentRepository repo, StudentMapper mapper) {
    this.repo = repo;
    this.mapper = mapper;
  }

  @Transactional
  public StudentDto create(StudentDto dto) {
    // Validación mínima (ejemplo)
    if (dto.getNombre() == null || dto.getNombre().isBlank()) {
      throw new IllegalArgumentException("name is required");
    }
    if (dto.getEmail() == null || dto.getEmail().isBlank()) {
      throw new IllegalArgumentException("email is required");
    }

    // DTO -> Entity
    StudentEntity entity = mapper.toEntity(dto);

    // Persistencia
    StudentEntity saved = repo.save(entity);

    // Entity -> DTO (respuesta)
    return mapper.toDto(saved);
  }

  @Transactional()
  public StudentDto findById(Long id) {
	  StudentEntity student = repo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("student not found"));
    
    return mapper.toDto(student);
  }
}