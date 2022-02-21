package br.casaaposta.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.casaaposta.main.entity.Odds;

public interface OddsRepository extends JpaRepository<Odds, Long> {

	Odds findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
		
	}
	

