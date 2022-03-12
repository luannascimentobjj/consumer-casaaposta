package br.casaaposta.main.bind;

import java.util.ArrayList;
import java.util.List;

import br.casaaposta.main.entity.Liga;
import br.casaaposta.main.entity.OddsEuroCup;
import br.casaaposta.main.entity.OddsPremierCup;
import br.casaaposta.main.entity.OddsSuperCup;
import br.casaaposta.main.entity.OddsWorldCup;
import br.casaaposta.main.entity.TipoResultadosOdds;
import br.casaaposta.main.model.OddsModel;
import br.casaaposta.main.util.ConstantsUtils;

public class FutServiceCast {

	public List<OddsPremierCup> castListOddsPremierCup(List<OddsModel> l, Liga liga) {
		List<OddsPremierCup> lista = new ArrayList();

		for (OddsModel odds : l) {
			if (odds.getTollTip() != null) {
				OddsPremierCup o = new OddsPremierCup();
				o.setAno(odds.getAno());
				o.setCodLiga(liga);
				o.setContable(odds.isContable());
				o.setData(odds.getData());
				o.setHora(odds.getHora());
				o.setId(odds.getId());
				o.setJogo(odds.getJogo());
				o.setMinuto(odds.getMinuto());
				o.setPercentual(odds.getPercentual());
				o.setResultado(odds.getResultado());
				o.setResultadoTipo(odds.getResultadoTipo());
				o.setSumScore(odds.getSumScore());
				o.setTimeCasa(odds.getTimeCasa());
				o.setTimeVisitante(odds.getTimeVisitante());
				o.setTollTip(odds.getTollTip());
				lista.add(o);
			}
		}
		return lista;
	}

	public List<OddsEuroCup> castListOddsEuroCup(List<OddsModel> l, Liga liga) {
		List<OddsEuroCup> lista = new ArrayList();

		for (OddsModel odds : l) {
			if (odds.getTollTip() != null) {
				OddsEuroCup o = new OddsEuroCup();
				o.setAno(odds.getAno());
				o.setCodLiga(liga);
				o.setContable(odds.isContable());
				o.setData(odds.getData());
				o.setHora(odds.getHora());
				o.setId(odds.getId());
				o.setJogo(odds.getJogo());
				o.setMinuto(odds.getMinuto());
				o.setPercentual(odds.getPercentual());
				o.setResultado(odds.getResultado());
				o.setResultadoTipo(odds.getResultadoTipo());
				o.setSumScore(odds.getSumScore());
				o.setTimeCasa(odds.getTimeCasa());
				o.setTimeVisitante(odds.getTimeVisitante());
				o.setTollTip(odds.getTollTip());
				lista.add(o);
			}
		}
		return lista;
	}

	public List<OddsSuperCup> castListOddsSuperCup(List<OddsModel> l, Liga liga) {
		List<OddsSuperCup> lista = new ArrayList();

		for (OddsModel odds : l) {
			if (odds.getTollTip() != null) {
				OddsSuperCup o = new OddsSuperCup();
				o.setAno(odds.getAno());
				o.setCodLiga(liga);
				o.setContable(odds.isContable());
				o.setData(odds.getData());
				o.setHora(odds.getHora());
				o.setId(odds.getId());
				o.setJogo(odds.getJogo());
				o.setMinuto(odds.getMinuto());
				o.setPercentual(odds.getPercentual());
				o.setResultado(odds.getResultado());
				o.setResultadoTipo(odds.getResultadoTipo());
				o.setSumScore(odds.getSumScore());
				o.setTimeCasa(odds.getTimeCasa());
				o.setTimeVisitante(odds.getTimeVisitante());
				o.setTollTip(odds.getTollTip());
				lista.add(o);
			}
		}
		return lista;
	}

	public List<OddsWorldCup> castListOddsWorldCup(List<OddsModel> l, Liga liga) {
		List<OddsWorldCup> lista = new ArrayList();

		for (OddsModel odds : l) {
			if (odds.getTollTip() != null) {
				OddsWorldCup o = new OddsWorldCup();
				o.setAno(odds.getAno());
				o.setCodLiga(liga);
				o.setContable(odds.isContable());
				o.setData(odds.getData());
				o.setHora(odds.getHora());
				o.setId(odds.getId());
				o.setJogo(odds.getJogo());
				o.setMinuto(odds.getMinuto());
				o.setPercentual(odds.getPercentual());
				o.setResultado(odds.getResultado());
				o.setResultadoTipo(odds.getResultadoTipo());
				o.setSumScore(odds.getSumScore());
				o.setTimeCasa(odds.getTimeCasa());
				o.setTimeVisitante(odds.getTimeVisitante());
				o.setTollTip(odds.getTollTip());
				lista.add(o);
			}
		}
		return lista;

	}
	
	
	public List<TipoResultadosOdds> preencheListaResultadoOdds(){
		
		List<TipoResultadosOdds> listToInsert = new ArrayList<>();
		listToInsert.add(new TipoResultadosOdds(ConstantsUtils.resultadoOver25));
		listToInsert.add(new TipoResultadosOdds(ConstantsUtils.resultadoCasa));
		listToInsert.add(new TipoResultadosOdds(ConstantsUtils.resultadoEmpate));
		listToInsert.add(new TipoResultadosOdds(ConstantsUtils.resultadoVisitante));
		listToInsert.add(new TipoResultadosOdds(ConstantsUtils.resultadoAmbasMarcam));
		listToInsert.add(new TipoResultadosOdds(ConstantsUtils.resultadoOver35));
		listToInsert.add(new TipoResultadosOdds(ConstantsUtils.resultadoUnder15));
		listToInsert.add(new TipoResultadosOdds(ConstantsUtils.resultadoUnder05));
			
		return listToInsert;
		
	}
	
}
