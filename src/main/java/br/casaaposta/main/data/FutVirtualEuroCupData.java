package br.casaaposta.main.data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import br.casaaposta.main.entity.Log;
import br.casaaposta.main.entity.OddsEuroCup;
import br.casaaposta.main.entity.Resultado;
import br.casaaposta.main.interfaces.FutVirtualEuroCupDataInterface;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.repository.OddsRepository;
import br.casaaposta.main.repository.ResultadoRepository;
import br.casaaposta.main.util.ConstantsUtils;
import lombok.Data;
@Data

public class FutVirtualEuroCupData implements FutVirtualEuroCupDataInterface {

	
	@Autowired 
	ResultadoRepository resultadoRepository_;
	@Autowired
	OddsRepository oddsRepository_;
	@Autowired
	LogRepository logRepository_;
	Log logger_ = new Log();
	
	public void salvarResultadoUnder05(List<OddsEuroCup> listUnder05) {
		try {
		
			List<OddsEuroCup> listToSave = new ArrayList<OddsEuroCup>();
			listUnder05.forEach(resultadoOver25 ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoOver25.getTollTip(), resultadoOver25.getMinuto(), resultadoOver25.getHora(), ConstantsUtils.resultadoUnder15);
				if (r1 == null) {
					listToSave.add(resultadoOver25);
				}
			});
		oddsRepository_.saveAllAndFlush(listToSave);
		
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.obterResultadoUnder05");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	
	public void salvarResultadoUnder15(List<OddsEuroCup> listUnder15) {
		try {
		
			List<OddsEuroCup> listToSave = new ArrayList<OddsEuroCup>();
			listUnder15.forEach(resultadoUnder15 ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoUnder15.getTollTip(), resultadoUnder15.getMinuto(), resultadoUnder15.getHora(), ConstantsUtils.resultadoUnder15);
				if (r1 == null) {
					listToSave.add(resultadoUnder15);
				}
			});
		oddsRepository_.saveAllAndFlush(listToSave);

		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.obterResultadoUnder15");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	
	public void salvarResultadoOver25(List<OddsEuroCup> listOver25) {
		try {
		
			List<OddsEuroCup> listToSave = new ArrayList<OddsEuroCup>();
			listOver25.forEach(resultadoOver25 ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoOver25.getTollTip(), resultadoOver25.getMinuto(), resultadoOver25.getHora(), ConstantsUtils.resultadoOver25);
				if (r1 == null) {
					listToSave.add(resultadoOver25);
				}
			});
		
		oddsRepository_.saveAllAndFlush(listToSave);
		
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.obterResultadoOver25");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoOver35(List<OddsEuroCup> listOver35) {
		try {
		
			
			List<OddsEuroCup> listToSave = new ArrayList<OddsEuroCup>();
			listOver35.forEach(resultadoOver35 ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoOver35.getTollTip(), resultadoOver35.getMinuto(), resultadoOver35.getHora(), ConstantsUtils.resultadoOver35);
				if (r1 == null) {
					listToSave.add(resultadoOver35);
				}
			});
	

		oddsRepository_.saveAllAndFlush(listToSave);

		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.obterResultadoOver35");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoCasa(List<OddsEuroCup> listCasa) {
		try {
		
			List<OddsEuroCup> listToSave = new ArrayList<OddsEuroCup>();
			listCasa.forEach(resultadoCasa ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoCasa.getTollTip(), resultadoCasa.getMinuto(), resultadoCasa.getHora(), ConstantsUtils.resultadoCasa);
				if (r1 == null) {
					listToSave.add(resultadoCasa);
				}
			});
	
		oddsRepository_.saveAllAndFlush(listToSave);
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.obterResultadoCasa");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoEmpate(List<OddsEuroCup> listEmpate) {
		try {
			
			List<OddsEuroCup> listToSave = new ArrayList<OddsEuroCup>();
			listEmpate.forEach(resultadoEmpate ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoEmpate.getTollTip(), resultadoEmpate.getMinuto(), resultadoEmpate.getHora(), ConstantsUtils.resultadoEmpate);
				if (r1 == null) {
					listToSave.add(resultadoEmpate);
				}
			});
		oddsRepository_.saveAllAndFlush(listToSave);
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.obterResultadoEmpate");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoVisitante(List<OddsEuroCup> listVisitante) {
		try {
		
			List<OddsEuroCup> listToSave = new ArrayList<OddsEuroCup>();
			listVisitante.forEach(resultadoVisitante ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoVisitante.getTollTip(), resultadoVisitante.getMinuto(), resultadoVisitante.getHora(), ConstantsUtils.resultadoVisitante);
				if (r1 == null) {
					listToSave.add(resultadoVisitante);
				}
			});
		oddsRepository_.saveAllAndFlush(listToSave);

		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.obterResultadoVisitante");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoAmbasMarcam(List<OddsEuroCup> listAmbasMarcam) {
		try {
		
			List<OddsEuroCup> listToSave = new ArrayList<OddsEuroCup>();
			listAmbasMarcam.forEach(resultadoAmbasMarcam ->{
				Resultado r1 = resultadoRepository_.findByTollTipAndMinutoAndHoraAndResultadoTipo(resultadoAmbasMarcam.getTollTip(), resultadoAmbasMarcam.getMinuto(), resultadoAmbasMarcam.getHora(), ConstantsUtils.resultadoAmbasMarcam);
				if (r1 == null) {
					listToSave.add(resultadoAmbasMarcam);
				}
			});
		oddsRepository_.saveAllAndFlush(listToSave);

		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.obterResultadoAmbas");
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
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.salvarResultadoHT");
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