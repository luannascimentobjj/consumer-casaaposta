package br.casaaposta.main.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import br.casaaposta.main.entity.Liga;

public interface LigaRepository extends JpaRepository<Liga, Integer> {

	@Query("Select l from Liga l where l.codLiga = :codLiga")
	Optional<Liga> findByCodLiga(String codLiga);


}
