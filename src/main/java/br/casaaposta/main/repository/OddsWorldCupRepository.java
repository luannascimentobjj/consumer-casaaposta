package br.casaaposta.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.casaaposta.main.entity.OddsEuroCup;
import br.casaaposta.main.entity.OddsWorldCup;

public interface OddsWorldCupRepository extends JpaRepository<OddsWorldCup, Long> {

	OddsEuroCup findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
		
	}
	

