package br.casaaposta.main.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import br.casaaposta.main.entity.Liga;
import br.casaaposta.main.entity.Log;
import br.casaaposta.main.entity.OddsEuroCup;
import br.casaaposta.main.entity.Resultado;
import br.casaaposta.main.interfaces.FutVirtualEuroCupDataInterface;
import br.casaaposta.main.repository.LigaRepository;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.service.FutVirtualServiceEuroCup;
import br.casaaposta.main.util.ConstantsUtils;

@Controller
public class FutVirtualEuroCupController {
	
	@Autowired
	FutVirtualServiceEuroCup futService_;
	@Autowired
	LogRepository logRepository_;
	private Liga liga;
	@Autowired
	private LigaRepository ligaRepository;
	@Autowired
	FutVirtualEuroCupDataInterface euroCupData_;
	Log logger_ = new Log();
	
	@Async
	public CompletableFuture<String> obterResultadoUnder05() {
		
		try {
			List<OddsEuroCup> listaUnder05 =  futService_.callServiceUnder05(liga);
			euroCupData_.salvarResultadoUnder05(listaUnder05);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualEuroCupController.obterResultadoUnder05");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

	}
	@Async
	public CompletableFuture<String> obterResultadoHT() {
		
		try {
			List<Resultado> listaResultadoHT =  futService_.callServiceResultadoHT(liga);
			euroCupData_.salvarResultadoHT(listaResultadoHT);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualEuroCupController.obterResultadoHT");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		
		return null;
	}
	
	@Async
	public CompletableFuture<String> obterResultadoFT() {
		
		try {
			System.out.println("obterResultadoFT");
			List<Resultado> listaResultadoFT =  futService_.callServiceResultadoFT(liga);
			euroCupData_.salvarResultadoFT(listaResultadoFT);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualEuroCupController.obterResultadoFT");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoUnder15() {
		
		try {
			System.out.println("obterResultadoUnder15");
			List<OddsEuroCup> listaUnder15 =  futService_.callServiceUnder15(liga);
			euroCupData_.salvarResultadoUnder15(listaUnder15);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualEuroCupController.obterResultadoUnder15");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoOver25() {
		
		try {
			System.out.println("obterResultadoOver25");
			List<OddsEuroCup> listaOver25 =  futService_.callServiceOver25(liga);
			euroCupData_.salvarResultadoOver25(listaOver25);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualEuroCupController.obterResultadoOver25");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoOver35() {
		
		try {
			System.out.println("obterResultadoOver35");
			List<OddsEuroCup> listaOver35 =  futService_.callServiceOver35(liga);
			euroCupData_.salvarResultadoOver35(listaOver35);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualEuroCupController.obterResultadoOver35");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoCasa() {
		
		try {
			System.out.println("obterResultadoCasa");
			List<OddsEuroCup> listaCasa =  futService_.callServiceCasa(liga);
			euroCupData_.salvarResultadoCasa(listaCasa);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualEuroCupController.obterResultadoCasa");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoEmpate() {
		
		try {
			System.out.println("obterResultadoEmpate");
			List<OddsEuroCup> listaEmpate =  futService_.callServiceEmpate(liga);
			euroCupData_.salvarResultadoEmpate(listaEmpate);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualEuroCupController.obterResultadoEmpate");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoVisitante() {
		
		try {
			System.out.println("obterResultadoVisitante");
			List<OddsEuroCup> listaVisitante =  futService_.callServiceVisitante(liga);
			euroCupData_.salvarResultadoVisitante(listaVisitante);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoVisitante");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

	}
	
	@Async
	public CompletableFuture<String> resetarCookie(){
		
	
		try {
			
			futService_.callResetCookie();
			
		}catch(Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualEuroCupController.resetarCookie");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;
	}
	
	
	
	@Async
	public CompletableFuture<String>  obterResultadoAmbasMarcam() {
		
		try {
			System.out.println("obterResultadoAmbasMarcam");
			List<OddsEuroCup> listaAmbasMarcam =  futService_.callServiceAmbasMarcam(liga);
			euroCupData_.salvarResultadoAmbasMarcam(listaAmbasMarcam);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualEuroCupController.obterResultadoAmbasMarcam");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	
	public void setLiga() {
		Optional<Liga> liga = ligaRepository.findByCodLiga(ConstantsUtils.idEuroCup);
		if (!liga.isPresent()) {
			Liga l1 = new Liga();
			l1.setNomeLiga("Euro Copa");
			l1.setCodLiga(ConstantsUtils.idEuroCup);
			this.liga = ligaRepository.save(l1);
		} else {
			this.liga = liga.get();
		}

	};
	

	
}
