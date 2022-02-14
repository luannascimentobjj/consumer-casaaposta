package br.casaaposta.main.repository;

import org.springframework.data.repository.CrudRepository;
import br.casaaposta.main.entity.Resultado;

public interface ResultadoRepository extends CrudRepository<Resultado, Long>{
	

	Resultado findByTollTipAndMinuto(String toolTip, int minuto);
		
	}


