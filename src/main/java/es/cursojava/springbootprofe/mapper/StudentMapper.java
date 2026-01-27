package es.cursojava.springbootprofe.mapper;

import org.springframework.stereotype.Component;

import es.cursojava.springbootprofe.entities.StudentEntity;
import es.cursojava.springbootprofe.model.StudentDto;

@Component
public class StudentMapper {

  public StudentEntity toEntity(StudentDto dto) {
    return new StudentEntity(dto.getNombre(), dto.getEmail());
  } 

  public StudentDto toDto(StudentEntity entity) {
    return new StudentDto(entity.getId(), entity.getName(), entity.getEmail(), entity.getEdad(), entity.getCurso());
  }
}
