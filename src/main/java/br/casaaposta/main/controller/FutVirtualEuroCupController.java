package br.casaaposta.main.controller;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;

import br.casaaposta.main.entity.Liga;
import br.casaaposta.main.entity.Log;
import br.casaaposta.main.entity.Odds;
import br.casaaposta.main.entity.Resultado;
import br.casaaposta.main.repository.LigaRepository;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.repository.OddsRepository;
import br.casaaposta.main.repository.ResultadoRepository;
import br.casaaposta.main.service.FutVirtualServiceEuroCup;
import br.casaaposta.main.util.UrlUtils;

@Controller
public class FutVirtualEuroCupController {
	
	@Autowired
	FutVirtualServiceEuroCup futService_;
	@Autowired
	OddsRepository oddsRepository_;
	@Autowired
	LogRepository logRepository_;
	@Autowired 
	ResultadoRepository resultadoRepository_;
	private Liga liga;
	@Autowired
	private LigaRepository ligaRepository;
	Log logger_ = new Log();
	private final String idCompetition = UrlUtils.idEuroCup;

	@Async
	public CompletableFuture<String> obterResultadoUnder05() {
		
		try {
			List<Odds> listaUnder05 =  futService_.callServiceUnder05();
			salvarResultadoUnder05(listaUnder05);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoUnder05");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
		return null;

	}
	@Async
	public CompletableFuture<String> obterResultadoHT() {
		
		try {
			List<Resultado> listaResultadoHT =  futService_.callServiceResultadoHT();
			salvarResultadoHT(listaResultadoHT);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoHT");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
		
		return null;
	}
	
	@Async
	public CompletableFuture<String> obterResultadoFT() {
		
		try {
			System.out.println("obterResultadoFT");
			List<Resultado> listaResultadoFT =  futService_.callServiceResultadoFT();
			salvarResultadoFT(listaResultadoFT);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoFT");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoUnder15() {
		
		try {
			System.out.println("obterResultadoUnder15");
			List<Odds> listaUnder15 =  futService_.callServiceUnder15();
			salvarResultadoUnder15(listaUnder15);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoUnder15");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoOver25() {
		
		try {
			System.out.println("obterResultadoOver25");
			List<Odds> listaOver25 =  futService_.callServiceOver25();
			salvarResultadoOver25(listaOver25);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoOver25");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoOver35() {
		
		try {
			System.out.println("obterResultadoOver35");
			List<Odds> listaOver35 =  futService_.callServiceOver35();
			salvarResultadoOver35(listaOver35);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoOver35");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoCasa() {
		
		try {
			System.out.println("obterResultadoCasa");
			List<Odds> listaCasa =  futService_.callServiceCasa();
			salvarResultadoCasa(listaCasa);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoCasa");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoEmpate() {
		
		try {
			System.out.println("obterResultadoEmpate");
			List<Odds> listaEmpate =  futService_.callServiceEmpate();
			salvarResultadoEmpate(listaEmpate);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoEmpate");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	@Async
	public CompletableFuture<String>  obterResultadoVisitante() {
		
		try {
			System.out.println("obterResultadoVisitante");
			List<Odds> listaVisitante =  futService_.callServiceVisitante();
			salvarResultadoVisitante(listaVisitante);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoVisitante");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	
	@Async
	public CompletableFuture<String>  obterResultadoAmbasMarcam() {
		
		try {
			System.out.println("obterResultadoAmbasMarcam");
			List<Odds> listaAmbasMarcam =  futService_.callServiceAmbasMarcam();
			salvarResultadoAmbasMarcam(listaAmbasMarcam);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoAmbasMarcam");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	
	
	
	
	
	public void salvarResultadoUnder05(List<Odds> listUnder05) {
		try {
		
	      //Verificar se existe duplicado.		
			//if (result.getTollTip() != null) {
			//	Resultado r1 = resultadoRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(
				//		result.getTollTip(), result.getMinuto(), result.getHora(), resultadoTipo);
			//	if (r1 == null) {
				//	resultadoRepository.save(result);
		//	}
		//	}
		Date d = new Date();
		Long time = d.getTime();
		System.out.println("Início do Save banco: Total da Execução - Under05 " + LocalTime.now());
		oddsRepository_.saveAllAndFlush(listUnder05);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado Under05 - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.obterResultadoUnder05");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
	}
	
	public void salvarResultadoUnder15(List<Odds> listUnder15) {
		try {
		
	      //Verificar se existe duplicado.		
			//if (result.getTollTip() != null) {
			//	Resultado r1 = resultadoRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(
				//		result.getTollTip(), result.getMinuto(), result.getHora(), resultadoTipo);
			//	if (r1 == null) {
				//	resultadoRepository.save(result);
		//	}
		//	}
		Date d = new Date();
		Long time = d.getTime();
		System.out.println("Início do Save banco: Total da Execução - Under15 " + LocalTime.now());
		oddsRepository_.saveAllAndFlush(listUnder15);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado Under15 - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.obterResultadoUnder15");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
	}
	
	public void salvarResultadoOver25(List<Odds> listOver25) {
		try {
		
	      //Verificar se existe duplicado.		
			//if (result.getTollTip() != null) {
			//	Resultado r1 = resultadoRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(
				//		result.getTollTip(), result.getMinuto(), result.getHora(), resultadoTipo);
			//	if (r1 == null) {
				//	resultadoRepository.save(result);
		//	}
		//	}
		Date d = new Date();
		Long time = d.getTime();
		System.out.println("Início do Save banco: Total da Execução - Over 25" + LocalTime.now());
		oddsRepository_.saveAllAndFlush(listOver25);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado Over25 - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.obterResultadoOver25");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoOver35(List<Odds> listOver35) {
		try {
		
	      //Verificar se existe duplicado.		
			//if (result.getTollTip() != null) {
			//	Resultado r1 = resultadoRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(
				//		result.getTollTip(), result.getMinuto(), result.getHora(), resultadoTipo);
			//	if (r1 == null) {
				//	resultadoRepository.save(result);
		//	}
		//	}
		Date d = new Date();
		Long time = d.getTime();
		System.out.println("Início do Save banco: Total da Execução - Over35" + LocalTime.now());
		oddsRepository_.saveAllAndFlush(listOver35);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado Over35 - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.obterResultadoOver35");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoCasa(List<Odds> listCasa) {
		try {
		
	      //Verificar se existe duplicado.		
			//if (result.getTollTip() != null) {
			//	Resultado r1 = resultadoRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(
				//		result.getTollTip(), result.getMinuto(), result.getHora(), resultadoTipo);
			//	if (r1 == null) {
				//	resultadoRepository.save(result);
		//	}
		//	}
		Date d = new Date();
		Long time = d.getTime();
		System.out.println("Início do Save banco: Total da Execução - Casa" + LocalTime.now());
		oddsRepository_.saveAllAndFlush(listCasa);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado Casa - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.obterResultadoCasa");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoEmpate(List<Odds> listEmpate) {
		try {
		
	      //Verificar se existe duplicado.		
			//if (result.getTollTip() != null) {
			//	Resultado r1 = resultadoRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(
				//		result.getTollTip(), result.getMinuto(), result.getHora(), resultadoTipo);
			//	if (r1 == null) {
				//	resultadoRepository.save(result);
		//	}
		//	}
		Date d = new Date();
		Long time = d.getTime();
		System.out.println("Início do Save banco: Total da Execução - Empate" + LocalTime.now());
		oddsRepository_.saveAllAndFlush(listEmpate);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado Empate - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.obterResultadoEmpate");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoVisitante(List<Odds> listVisitante) {
		try {
		
	      //Verificar se existe duplicado.		
			//if (result.getTollTip() != null) {
			//	Resultado r1 = resultadoRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(
				//		result.getTollTip(), result.getMinuto(), result.getHora(), resultadoTipo);
			//	if (r1 == null) {
				//	resultadoRepository.save(result);
		//	}
		//	}
		Date d = new Date();
		Long time = d.getTime();
		System.out.println("Início do Save banco: Total da Execução - Visitante" + LocalTime.now());
		oddsRepository_.saveAllAndFlush(listVisitante);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado Visitante - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.obterResultadoVisitante");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoAmbasMarcam(List<Odds> listAmbasMarcam) {
		try {
		
	      //Verificar se existe duplicado.		
			//if (result.getTollTip() != null) {
			//	Resultado r1 = resultadoRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(
				//		result.getTollTip(), result.getMinuto(), result.getHora(), resultadoTipo);
			//	if (r1 == null) {
				//	resultadoRepository.save(result);
		//	}
		//	}
		Date d = new Date();
		Long time = d.getTime();
		System.out.println("Início do Save banco: Total da Execução - Ambas" + LocalTime.now());
		oddsRepository_.saveAllAndFlush(listAmbasMarcam);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado Ambas - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.obterResultadoAmbas");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoHT(List<Resultado> listResultado) {
		try {
		Date d = new Date();
		Long time = d.getTime();
		System.out.println("Início do Save banco: Total da Execução - HT " + LocalTime.now());
		resultadoRepository_.saveAllAndFlush(listResultado);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado HT - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.salvarResultadoHT");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
		
	}
	
	public void salvarResultadoFT(List<Resultado> listResultado) {
		try {
		Date d = new Date();
		Long time = d.getTime();
		System.out.println("Início do Save banco: Total da Execução - FT " + LocalTime.now());
		resultadoRepository_.saveAllAndFlush(listResultado);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado FT - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.salvarResultadoFT");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
		
	}
	
	public void setLiga() {
		Optional<Liga> liga = ligaRepository.findByCodLiga(idCompetition);
		if (!liga.isPresent()) {
			Liga l1 = new Liga();
			l1.setNomeLiga("Euro Copa");
			l1.setCodLiga(idCompetition);
			this.liga = ligaRepository.save(l1);
		} else {
			this.liga = liga.get();
		}

	};
	
}
