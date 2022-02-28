package br.casaaposta.main.data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import br.casaaposta.main.entity.Log;
import br.casaaposta.main.entity.OddsSuperCup;
import br.casaaposta.main.entity.Resultado;
import br.casaaposta.main.interfaces.FutVirtualSuperCupDataInterface;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.repository.OddsSuperCupRepository;
import br.casaaposta.main.repository.ResultadoRepository;
import br.casaaposta.main.util.ConstantsUtils;

public class FutVirtualSuperCupData implements FutVirtualSuperCupDataInterface{
	
	@Autowired
	OddsSuperCupRepository oddsRepository_;
	@Autowired
	LogRepository logRepository_;
	@Autowired 
	ResultadoRepository resultadoRepository_;
	Log logger_ = new Log();

	public void salvarResultadoUnder05(List<OddsSuperCup> listUnder05) {
		try {
		
			
			List<OddsSuperCup> listToSave = new ArrayList<OddsSuperCup>();
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
	
	public void salvarResultadoUnder15(List<OddsSuperCup> listUnder15) {
		try {
		
			
			List<OddsSuperCup> listToSave = new ArrayList<OddsSuperCup>();
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
	
	public void salvarResultadoOver25(List<OddsSuperCup> listOver25) {
		try {
		
			
			List<OddsSuperCup> listToSave = new ArrayList<OddsSuperCup>();
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
	public void salvarResultadoOver35(List<OddsSuperCup> listOver35) {
		try {
			
			List<OddsSuperCup> listToSave = new ArrayList<OddsSuperCup>();
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
	public void salvarResultadoCasa(List<OddsSuperCup> listCasa) {
		try {
		
			List<OddsSuperCup> listToSave = new ArrayList<OddsSuperCup>();
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
	public void salvarResultadoEmpate(List<OddsSuperCup> listEmpate) {
		try {
		
			List<OddsSuperCup> listToSave = new ArrayList<OddsSuperCup>();
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
	public void salvarResultadoVisitante(List<OddsSuperCup> listVisitante) {
		try {
		
			List<OddsSuperCup> listToSave = new ArrayList<OddsSuperCup>();
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
	public void salvarResultadoAmbasMarcam(List<OddsSuperCup> listAmbasMarcam) {
		try {
		
			List<OddsSuperCup> listToSave = new ArrayList<OddsSuperCup>();
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
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.salvarResultadoFT");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		
	}
	
}
