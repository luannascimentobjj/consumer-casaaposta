package br.casaaposta.main.bind;

import java.util.ArrayList;
import java.util.List;

import br.casaaposta.main.entity.Liga;
import br.casaaposta.main.entity.OddsEuroCup;
import br.casaaposta.main.entity.OddsPremierCup;
import br.casaaposta.main.entity.OddsSuperCup;
import br.casaaposta.main.entity.OddsWorldCup;
import br.casaaposta.main.entity.TipoResultado;
import br.casaaposta.main.model.OddsModel;
import br.casaaposta.main.util.ConstantsUtils;

public class FutServiceCast {

	public List<OddsPremierCup> castListOddsPremierCup(List<OddsModel> l, Liga liga) {
		List<OddsPremierCup> lista = new ArrayList<OddsPremierCup>();

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
		List<OddsEuroCup> lista = new ArrayList<OddsEuroCup>();

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
		List<OddsSuperCup> lista = new ArrayList<OddsSuperCup>();

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
		List<OddsWorldCup> lista = new ArrayList<OddsWorldCup>();

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
	
	
	public List<TipoResultado> preencheListaResultado(){
		
		List<TipoResultado> listToInsert = new ArrayList<>();
		listToInsert.add(new TipoResultado(ConstantsUtils.resultadoOver25, true));
		listToInsert.add(new TipoResultado(ConstantsUtils.resultadoCasa, true));
		listToInsert.add(new TipoResultado(ConstantsUtils.resultadoEmpate, true));
		listToInsert.add(new TipoResultado(ConstantsUtils.resultadoVisitante, true));
		listToInsert.add(new TipoResultado(ConstantsUtils.resultadoAmbasMarcam, true));
		listToInsert.add(new TipoResultado(ConstantsUtils.resultadoOver35, true));
		listToInsert.add(new TipoResultado(ConstantsUtils.resultadoUnder15, true));
		listToInsert.add(new TipoResultado(ConstantsUtils.resultadoUnder05, true));
		listToInsert.add(new TipoResultado(ConstantsUtils.resultadoFT, false));
		listToInsert.add(new TipoResultado(ConstantsUtils.resultadoHT, false));
			
		return listToInsert;
		
	}
	
}
