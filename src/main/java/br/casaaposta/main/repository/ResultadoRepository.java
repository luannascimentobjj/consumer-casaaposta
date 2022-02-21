package br.casaaposta.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.casaaposta.main.entity.Resultado;

public interface ResultadoRepository extends JpaRepository<Resultado, Long>{
	

	Resultado findByTollTipAndMinutoAndHoraAndResultadoTipo(String toolTip, int minuto, int hora, String resultadoTipo);
		
	}


