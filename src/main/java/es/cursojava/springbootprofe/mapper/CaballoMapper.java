package es.cursojava.springbootprofe.mapper;

import org.springframework.stereotype.Component;

import es.cursojava.springbootprofe.entities.CaballoEntity;
import es.cursojava.springbootprofe.model.CaballoDto;

@Component
public class CaballoMapper {

	public CaballoEntity toEntity(CaballoDto dto) {
		return new CaballoEntity(dto.getId(), dto.getNombre(), dto.getEdad(), dto.getDorsal(), dto.getPeso(),
				dto.getVelocidad(), dto.getExperiencia());
	}

	public CaballoDto toDto(CaballoEntity entity) {
		return new CaballoDto(entity.getId(), entity.getNombre(), entity.getEdad(), entity.getDorsal(),
				entity.getPeso(), entity.getVelocidad(), entity.getExperiencia());
	}

	public CaballoDto toDtoGanador(CaballoEntity entity) {
		return new CaballoDto(entity.getId(), entity.getNombre());

	}

}
