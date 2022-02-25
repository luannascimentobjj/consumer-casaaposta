package br.casaaposta.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.casaaposta.main.entity.Odds;
import br.casaaposta.main.entity.OddsPremierCup;

public interface OddsPremierCupRepository extends JpaRepository<OddsPremierCup, Long> {

	Odds findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
		
	}
	

