package br.casaaposta.main.data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.Log;
import br.casaaposta.main.entity.OddsWorldCup;
import br.casaaposta.main.entity.Resultado;
import br.casaaposta.main.interfaces.FutVirtualWorldCupDataInterface;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.repository.OddsWorldCupRepository;
import br.casaaposta.main.repository.ResultadoRepository;
import br.casaaposta.main.util.ConstantsUtils;

@Component
public class FutVirtualWorldCupData implements FutVirtualWorldCupDataInterface{

	@Autowired
	OddsWorldCupRepository oddsRepository_;
	@Autowired 
	ResultadoRepository resultadoRepository_;
	@Autowired
	LogRepository logRepository_;
	Log logger_ = new Log();
	
	public void salvarResultadoUnder05(List<OddsWorldCup> listUnder05) {
		try {
		
			List<OddsWorldCup> listToSave = new ArrayList<OddsWorldCup>();
			listUnder05.forEach(resultadoUnder05 ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoUnder05.getTollTip(), resultadoUnder05.getMinuto(), resultadoUnder05.getHora(), ConstantsUtils.resultadoUnder05);
				if (r1 == null) {
					listToSave.add(resultadoUnder05);
				}
			});
		oddsRepository_.saveAllAndFlush(listToSave);
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.obterResultadoUnder05");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	
	public void salvarResultadoUnder15(List<OddsWorldCup> listUnder15) {
		try {
		
			List<OddsWorldCup> listToSave = new ArrayList<OddsWorldCup>();
			listUnder15.forEach(resultadoUnder15 ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoUnder15.getTollTip(), resultadoUnder15.getMinuto(), resultadoUnder15.getHora(), ConstantsUtils.resultadoUnder15);
				if (r1 == null) {
					listToSave.add(resultadoUnder15);
				}
			});

		oddsRepository_.saveAllAndFlush(listToSave);
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.obterResultadoUnder15");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	
	public void salvarResultadoOver25(List<OddsWorldCup> listOver25) {
		try {
		
			List<OddsWorldCup> listToSave = new ArrayList<OddsWorldCup>();
			listOver25.forEach(resultadoOver25 ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoOver25.getTollTip(), resultadoOver25.getMinuto(), resultadoOver25.getHora(), ConstantsUtils.resultadoOver25);
				if (r1 == null) {
					listToSave.add(resultadoOver25);
				}
			});
		
		oddsRepository_.saveAllAndFlush(listToSave);
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.obterResultadoOver25");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoOver35(List<OddsWorldCup> listOver35) {
		try {
		
			
			List<OddsWorldCup> listToSave = new ArrayList<OddsWorldCup>();
			listOver35.forEach(resultadoOver35 ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoOver35.getTollTip(), resultadoOver35.getMinuto(), resultadoOver35.getHora(), ConstantsUtils.resultadoOver35);
				if (r1 == null) {
					listToSave.add(resultadoOver35);
				}
			});
		
		oddsRepository_.saveAllAndFlush(listToSave);
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.obterResultadoOver35");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoCasa(List<OddsWorldCup> listCasa) {
		try {
		
			
			List<OddsWorldCup> listToSave = new ArrayList<OddsWorldCup>();
			listCasa.forEach(resultadoCasa ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoCasa.getTollTip(), resultadoCasa.getMinuto(), resultadoCasa.getHora(), ConstantsUtils.resultadoCasa);
				if (r1 == null) {
					listToSave.add(resultadoCasa);
				}
			});

		oddsRepository_.saveAllAndFlush(listToSave);

		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.obterResultadoCasa");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoEmpate(List<OddsWorldCup> listEmpate) {
		try {
		
			List<OddsWorldCup> listToSave = new ArrayList<OddsWorldCup>();
			listEmpate.forEach(resultadoEmpate ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoEmpate.getTollTip(), resultadoEmpate.getMinuto(), resultadoEmpate.getHora(), ConstantsUtils.resultadoEmpate);
				if (r1 == null) {
					listToSave.add(resultadoEmpate);
				}
			});
		oddsRepository_.saveAllAndFlush(listToSave);
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.obterResultadoEmpate");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoVisitante(List<OddsWorldCup> listVisitante) {
		try {
		
			List<OddsWorldCup> listToSave = new ArrayList<OddsWorldCup>();
			listVisitante.forEach(resultadoVisitante ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoVisitante.getTollTip(), resultadoVisitante.getMinuto(), resultadoVisitante.getHora(), ConstantsUtils.resultadoVisitante);
				if (r1 == null) {
					listToSave.add(resultadoVisitante);
				}
			});

		oddsRepository_.saveAllAndFlush(listToSave);
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.obterResultadoVisitante");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoAmbasMarcam(List<OddsWorldCup> listAmbasMarcam) {
		try {
		
			List<OddsWorldCup> listToSave = new ArrayList<OddsWorldCup>();
			listAmbasMarcam.forEach(resultadoAmbasMarcam ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoAmbasMarcam.getTollTip(), resultadoAmbasMarcam.getMinuto(), resultadoAmbasMarcam.getHora(), ConstantsUtils.resultadoAmbasMarcam);
				if (r1 == null) {
					listToSave.add(resultadoAmbasMarcam);
				}
			});
		oddsRepository_.saveAllAndFlush(listToSave);
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.obterResultadoAmbas");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoHT(List<Resultado> listResultado) {
		try {

			
			List<Resultado> listToSave = new ArrayList<Resultado>();
			listResultado.forEach(resultadoHT ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoHT.getTollTip(), resultadoHT.getMinuto(), resultadoHT.getHora(), ConstantsUtils.resultadoHT);
				if (r1 == null) {
					listToSave.add(resultadoHT);
				}
			});
			
			resultadoRepository_.saveAllAndFlush(listToSave);
		
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.salvarResultadoHT");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		
	}
	
	public void salvarResultadoFT(List<Resultado> listResultado) {
		try {

			List<Resultado> listToSave = new ArrayList<Resultado>();
			listResultado.forEach(resultadoFT ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoFT.getTollTip(), resultadoFT.getMinuto(), resultadoFT.getHora(), ConstantsUtils.resultadoFT);
				if (r1 == null) {
					listToSave.add(resultadoFT);
				}
			});
			
			resultadoRepository_.saveAllAndFlush(listToSave);	
			
		resultadoRepository_.saveAllAndFlush(listResultado);
		
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.salvarResultadoFT");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		
	}
	
	
}
