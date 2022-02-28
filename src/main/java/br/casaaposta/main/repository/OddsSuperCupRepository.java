package br.casaaposta.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.casaaposta.main.entity.OddsEuroCup;
import br.casaaposta.main.entity.OddsSuperCup;

public interface OddsSuperCupRepository extends JpaRepository<OddsSuperCup, Long> {

	OddsEuroCup findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
		
	}
	

