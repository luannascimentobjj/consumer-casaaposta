package br.casaaposta.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casaaposta.main.entity.TipoResultados;

public interface TipoResultadosOddsRepository extends JpaRepository<TipoResultados, Long>{
	
	List<TipoResultados> findAll();

}
