package br.casaaposta.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.casaaposta.main.entity.Odds;
import br.casaaposta.main.entity.OddsSuperCup;

public interface OddsSuperCupRepository extends JpaRepository<OddsSuperCup, Long> {

	Odds findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
		
	}
	

