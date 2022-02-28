package br.casaaposta.main.interfaces;

import java.util.List;

import br.casaaposta.main.entity.OddsEuroCup;
import br.casaaposta.main.entity.Resultado;

public interface FutVirtualEuroCupDataInterface {

	void salvarResultadoUnder05(List<OddsEuroCup> listUnder05);
	void salvarResultadoUnder15(List<OddsEuroCup> listUnder15);
	void salvarResultadoOver25(List<OddsEuroCup> listOver25);
	void salvarResultadoOver35(List<OddsEuroCup> listOver35);
	void salvarResultadoCasa(List<OddsEuroCup> listCasa);
	void salvarResultadoEmpate(List<OddsEuroCup> listEmpate);
	void salvarResultadoVisitante(List<OddsEuroCup> listVisitante);
	void salvarResultadoAmbasMarcam(List<OddsEuroCup> listAmbasMarcam);
	void salvarResultadoHT(List<Resultado> listResultado);
	void salvarResultadoFT(List<Resultado> listResultado);
}
