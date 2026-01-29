package es.cursojava.springbootprofe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.cursojava.springbootprofe.entities.CaballoEntity;

public interface CaballoRepository extends JpaRepository<CaballoEntity, Long> {

	public CaballoEntity findByNombre(String nombre);
	
//	@Query("FROM CaballoEntity c WHERE c.disponible = :disponible")
//	public List<CaballoEntity> findAllAvailableCaballos(@Param("disponible") boolean disponible);

}
