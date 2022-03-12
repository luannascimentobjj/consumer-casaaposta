package br.casaaposta.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casaaposta.main.entity.TipoResultadosOdds;

public interface TipoResultadosOddsRepository extends JpaRepository<TipoResultadosOdds, Long>{
	
	List<TipoResultadosOdds> findAll();

}
