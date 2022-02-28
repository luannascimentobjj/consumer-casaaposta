package br.casaaposta.main.interfaces;

import java.util.List;

import br.casaaposta.main.entity.OddsPremierCup;
import br.casaaposta.main.entity.Resultado;

public interface FutVirtualPremierCupDataInterface {

	void salvarResultadoUnder05(List<OddsPremierCup> listUnder05);
	void salvarResultadoUnder15(List<OddsPremierCup> listUnder15);
	void salvarResultadoOver25(List<OddsPremierCup> listOver25);
	void salvarResultadoOver35(List<OddsPremierCup> listOver35);
	void salvarResultadoCasa(List<OddsPremierCup> listCasa);
	void salvarResultadoEmpate(List<OddsPremierCup> listEmpate);
	void salvarResultadoVisitante(List<OddsPremierCup> listVisitante);
	void salvarResultadoAmbasMarcam(List<OddsPremierCup> listAmbasMarcam);
	void salvarResultadoHT(List<Resultado> listResultado);
	void salvarResultadoFT(List<Resultado> listResultado);
	
	
	
}
