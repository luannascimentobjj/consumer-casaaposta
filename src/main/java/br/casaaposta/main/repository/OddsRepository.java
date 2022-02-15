package br.casaaposta.main.repository;

import org.springframework.data.repository.CrudRepository;
import br.casaaposta.main.entity.Odds;
import br.casaaposta.main.entity.Resultado;

public interface OddsRepository extends CrudRepository<Odds, Long> {

	Odds findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
		
	}
	

