package br.casaaposta.main.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.casaaposta.main.entity.Liga;

public interface LigaRepository extends CrudRepository<Liga, Integer> {

	@Query("Select l from Liga l where l.codLiga = :codLiga")
	Optional<Liga> findByCodLiga(String codLiga);


}
