package br.casaaposta.main.interfaces;

import java.util.List;

import br.casaaposta.main.entity.OddsWorldCup;
import br.casaaposta.main.entity.Resultado;

public interface FutVirtualWorldCupDataInterface {

	void salvarResultadoUnder05(List<OddsWorldCup> listUnder05);
	void salvarResultadoUnder15(List<OddsWorldCup> listUnder15);
	void salvarResultadoOver25(List<OddsWorldCup> listOver25);
	void salvarResultadoOver35(List<OddsWorldCup> listOver35);
	void salvarResultadoCasa(List<OddsWorldCup> listCasa);
	void salvarResultadoEmpate(List<OddsWorldCup> listEmpate);
	void salvarResultadoVisitante(List<OddsWorldCup> listVisitante);
	void salvarResultadoAmbasMarcam(List<OddsWorldCup> listAmbasMarcam);
	void salvarResultadoHT(List<Resultado> listResultado);
	void salvarResultadoFT(List<Resultado> listResultado);
	
	
}
