package br.casaaposta.main.bind;

import java.util.ArrayList;
import java.util.List;

import br.casaaposta.main.entity.Liga;
import br.casaaposta.main.entity.OddsEuroCup;
import br.casaaposta.main.entity.OddsPremierCup;
import br.casaaposta.main.entity.OddsSuperCup;
import br.casaaposta.main.entity.OddsWorldCup;
import br.casaaposta.main.model.OddsModel;

public class FutServiceCast {

	public List<OddsPremierCup> castListOddsPremierCup(List<OddsModel> l, Liga liga){
		List<OddsPremierCup> lista = new ArrayList();
		
		for (OddsModel odds : l) {
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
		return lista;
	}
	
	
	public List<OddsEuroCup> castListOddsEuroCup(List<OddsModel> l, Liga liga){
		List<OddsEuroCup> lista = new ArrayList();
		
		for (OddsModel odds : l) {
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
		return lista;
	}
	
	
	public List<OddsSuperCup> castListOddsSuperCup(List<OddsModel> l, Liga liga){
		List<OddsSuperCup> lista = new ArrayList();
		
		for (OddsModel odds : l) {
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
		return lista;
	}
	
	public List<OddsWorldCup> castListOddsWorldCup(List<OddsModel> l, Liga liga){
		List<OddsWorldCup> lista = new ArrayList();
		
		for (OddsModel odds : l) {
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
		return lista;
	}
}
