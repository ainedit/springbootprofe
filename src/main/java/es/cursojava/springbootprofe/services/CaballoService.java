package es.cursojava.springbootprofe.services;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import es.cursojava.springbootprofe.entities.CaballoEntity;
import es.cursojava.springbootprofe.mapper.CaballoMapper;
import es.cursojava.springbootprofe.model.CaballoDto;
import es.cursojava.springbootprofe.repositories.CaballoRepository;


@Service
public class CaballoService {
	private final CaballoRepository caballoRepository;
	private final CaballoMapper caballoMapper;
	
	public CaballoService(CaballoRepository caballoRepository, CaballoMapper caballoMapper) {
		super();
		this.caballoRepository = caballoRepository;
		this.caballoMapper = caballoMapper;
	}


	public List<CaballoDto> obtenerCaballosDisponibles() {
		
		List<CaballoEntity> caballosEntity = caballoRepository.findAll();
		
		return caballosEntity.stream().map(caballoMapper::toDto).toList();
	}
	
	
	public CaballoDto guardarCaballo(CaballoDto caballoDto) {
		CaballoEntity caballoEntity = caballoMapper.toEntity(caballoDto);
		CaballoEntity caballoGuardado = caballoRepository.save(caballoEntity);
		return caballoMapper.toDto(caballoGuardado);
	}
	
	
	public CaballoDto iniciarCarrera() {
		List<CaballoEntity> caballosEntity = caballoRepository.findAll();
		
		return determinarGanador(caballosEntity);
	}
	
	
	private CaballoDto determinarGanador(List<CaballoEntity> caballosEntity) {
		
		Random random = new Random();
		int numeroCaballoGanador = random.nextInt(caballosEntity.size());
		
		return caballosEntity.get(numeroCaballoGanador)!=null ? caballoMapper.toDto(caballosEntity.get(numeroCaballoGanador)) : null;
	}
}










