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
import br.casaaposta.main.entity.OddsSuperCup;
import br.casaaposta.main.entity.Resultado;
import br.casaaposta.main.interfaces.FutVirtualSuperCupDataInterface;
import br.casaaposta.main.repository.LigaRepository;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.service.FutVirtualServiceSuperCup;
import br.casaaposta.main.util.ConstantsUtils;

@Controller
public class FutVirtualSuperCupController {
	
	@Autowired
	FutVirtualServiceSuperCup futService_;
	@Autowired
	LogRepository logRepository_;
	@Autowired
	private LigaRepository ligaRepository_;
	@Autowired
	private FutVirtualSuperCupDataInterface futSuperCupData_;
	Log logger_ = new Log();
	private Liga liga;
	

	@Async
	public CompletableFuture<String> obterResultadoUnder05() {
		
		try {
			List<OddsSuperCup> listaUnder05 =  futService_.callServiceResultadoUnder05(liga);
			futSuperCupData_.salvarResultadoUnder05(listaUnder05);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoUnder05");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

	}
	@Async
	public CompletableFuture<String> obterResultadoHT() {
		
		try {
			List<Resultado> listaResultadoHT =  futService_.callServiceResultadoHT(liga);
			futSuperCupData_.salvarResultadoHT(listaResultadoHT);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoHT");
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
			futSuperCupData_.salvarResultadoFT(listaResultadoFT);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoFT");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoUnder15() {
		
		try {
			System.out.println("obterResultadoUnder15");
			List<OddsSuperCup> listaUnder15 =  futService_.callServiceResultadoUnder15(liga);
			futSuperCupData_.salvarResultadoUnder15(listaUnder15);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoUnder15");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoOver25() {
		
		try {
			System.out.println("obterResultadoOver25");
			List<OddsSuperCup> listaOver25 =  futService_.callServiceResultadoOver25(liga);
			futSuperCupData_.salvarResultadoOver25(listaOver25);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoOver25");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoOver35() {
		
		try {
			System.out.println("obterResultadoOver35");
			List<OddsSuperCup> listaOver35 =  futService_.callServiceResultadoOver35(liga);
			futSuperCupData_.salvarResultadoOver35(listaOver35);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoOver35");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoCasa() {
		
		try {
			System.out.println("obterResultadoCasa");
			List<OddsSuperCup> listaCasa =  futService_.callServiceResultadoCasa(liga);
			futSuperCupData_.salvarResultadoCasa(listaCasa);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoCasa");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoEmpate() {
		
		try {
			System.out.println("obterResultadoEmpate");
			List<OddsSuperCup> listaEmpate =  futService_.callServiceResultadoEmpate(liga);
			futSuperCupData_.salvarResultadoEmpate(listaEmpate);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoEmpate");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoVisitante() {
		
		try {
			System.out.println("obterResultadoVisitante");
			List<OddsSuperCup> listaVisitante =  futService_.callServiceResultadoVisitante(liga);
			futSuperCupData_.salvarResultadoVisitante(listaVisitante);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoVisitante");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	
	@Async
	public CompletableFuture<String>  obterResultadoAmbasMarcam() {
		
		try {
			System.out.println("obterResultadoAmbasMarcam");
			List<OddsSuperCup> listaAmbasMarcam =  futService_.callServiceResultadoAmbasMarcam(liga);
			futSuperCupData_.salvarResultadoAmbasMarcam(listaAmbasMarcam);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoAmbasMarcam");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	
	
	public void setLiga() {
		Optional<Liga> liga = ligaRepository_.findByCodLiga(ConstantsUtils.idSuperLeagueCup);
		if (!liga.isPresent()) {
			Liga l1 = new Liga();
			l1.setNomeLiga("Euro Copa");
			l1.setCodLiga(ConstantsUtils.idSuperLeagueCup);
			this.liga = ligaRepository_.save(l1);
		} else {
			this.liga = liga.get();
		}

	};
	
}
