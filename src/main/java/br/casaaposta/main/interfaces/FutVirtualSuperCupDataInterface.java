package br.casaaposta.main.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.OddsSuperCup;
import br.casaaposta.main.entity.Resultado;

public interface FutVirtualSuperCupDataInterface {
	
	
	void salvarResultadoUnder05(List<OddsSuperCup> listUnder05);
	
	void salvarResultadoUnder15(List<OddsSuperCup> listUnder15);
	
	void salvarResultadoOver25(List<OddsSuperCup> listOver25);
	
	void salvarResultadoOver35(List<OddsSuperCup> listOver35);
	
	void salvarResultadoCasa(List<OddsSuperCup> listCasa);
	
	void salvarResultadoEmpate(List<OddsSuperCup> listEmpate);
	
	void salvarResultadoVisitante(List<OddsSuperCup> listVisitante);
	
	void salvarResultadoAmbasMarcam(List<OddsSuperCup> listAmbasMarcam);
	
	void salvarResultadoHT(List<Resultado> listResultado);
	
	void salvarResultadoFT(List<Resultado> listResultado);
	
}
