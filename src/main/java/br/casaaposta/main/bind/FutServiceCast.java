package br.casaaposta.main.bind;

import java.util.ArrayList;
import java.util.List;

import br.casaaposta.main.entity.Liga;
import br.casaaposta.main.entity.Odds;
import br.casaaposta.main.model.OddsModel;

public class FutServiceCast {

	public List<Odds> castList(List<OddsModel> l, Liga liga){
		List<Odds> lista = new ArrayList();
		
		for (OddsModel odds : l) {
			Odds o = new Odds();
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
