package br.casaaposta.main.controller;

import java.time.LocalDateTime;
import java.util.Date;
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
import br.casaaposta.main.repository.LigaRepository;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.repository.OddsRepository;
import br.casaaposta.main.repository.ResultadoRepository;
import br.casaaposta.main.service.FutVirtualServiceEuroCup;
import br.casaaposta.main.util.ConstantsUtils;

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
	private final String idCompetition = ConstantsUtils.idEuroCup;

	@Async
	public CompletableFuture<String> obterResultadoUnder05() {
		
		try {
			List<OddsEuroCup> listaUnder05 =  futService_.callServiceUnder05(liga);
			salvarResultadoUnder05(listaUnder05);
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
			salvarResultadoHT(listaResultadoHT);
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
			salvarResultadoFT(listaResultadoFT);
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
			salvarResultadoUnder15(listaUnder15);
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
			salvarResultadoOver25(listaOver25);
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
			salvarResultadoOver35(listaOver35);
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
			salvarResultadoCasa(listaCasa);
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
			salvarResultadoEmpate(listaEmpate);
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
			salvarResultadoVisitante(listaVisitante);
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
			salvarResultadoAmbasMarcam(listaAmbasMarcam);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualEuroCupController.obterResultadoAmbasMarcam");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	
	
	
	
	
	public void salvarResultadoUnder05(List<OddsEuroCup> listUnder05) {
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
		System.out.println("Início do Save banco: Total da Execução - Under05 " + LocalDateTime.now());
		oddsRepository_.saveAllAndFlush(listUnder05);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado Under05 - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalDateTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.obterResultadoUnder05");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	
	public void salvarResultadoUnder15(List<OddsEuroCup> listUnder15) {
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
		System.out.println("Início do Save banco: Total da Execução - Under15 " + LocalDateTime.now());
		oddsRepository_.saveAllAndFlush(listUnder15);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado Under15 - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalDateTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.obterResultadoUnder15");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	
	public void salvarResultadoOver25(List<OddsEuroCup> listOver25) {
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
		System.out.println("Início do Save banco: Total da Execução - Over 25" + LocalDateTime.now());
		oddsRepository_.saveAllAndFlush(listOver25);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado Over25 - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalDateTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.obterResultadoOver25");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoOver35(List<OddsEuroCup> listOver35) {
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
		System.out.println("Início do Save banco: Total da Execução - Over35" + LocalDateTime.now());
		oddsRepository_.saveAllAndFlush(listOver35);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado Over35 - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalDateTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.obterResultadoOver35");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoCasa(List<OddsEuroCup> listCasa) {
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
		System.out.println("Início do Save banco: Total da Execução - Casa" + LocalDateTime.now());
		oddsRepository_.saveAllAndFlush(listCasa);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado Casa - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalDateTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.obterResultadoCasa");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoEmpate(List<OddsEuroCup> listEmpate) {
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
		System.out.println("Início do Save banco: Total da Execução - Empate" + LocalDateTime.now());
		oddsRepository_.saveAllAndFlush(listEmpate);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado Empate - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalDateTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.obterResultadoEmpate");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoVisitante(List<OddsEuroCup> listVisitante) {
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
		System.out.println("Início do Save banco: Total da Execução - Visitante" + LocalDateTime.now());
		oddsRepository_.saveAllAndFlush(listVisitante);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado Visitante - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalDateTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.obterResultadoVisitante");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoAmbasMarcam(List<OddsEuroCup> listAmbasMarcam) {
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
		System.out.println("Início do Save banco: Total da Execução - Ambas" + LocalDateTime.now());
		oddsRepository_.saveAllAndFlush(listAmbasMarcam);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado Ambas - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalDateTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.obterResultadoAmbas");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
	}
	public void salvarResultadoHT(List<Resultado> listResultado) {
		try {
		Date d = new Date();
		Long time = d.getTime();
		System.out.println("Início do Save banco: Total da Execução - HT " + LocalDateTime.now());
		resultadoRepository_.saveAllAndFlush(listResultado);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado HT - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalDateTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualEuroCupController.salvarResultadoHT");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		
	}
	
	public void salvarResultadoFT(List<Resultado> listResultado) {
		try {
		Date d = new Date();
		Long time = d.getTime();
		System.out.println("Início do Save banco: Total da Execução - FT " + LocalDateTime.now());
		resultadoRepository_.saveAllAndFlush(listResultado);
		time = d.getTime() - time;
		System.out.println("Salvou Resultado no Banco, resultado FT - Tempo em ms : " + String.valueOf(time) );
		System.out.println("Tempo total da Execução -" + LocalDateTime.now());
		}catch  (Exception e){
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar salvar informações no banco, FutVirtualServiceEuroCup.salvarResultadoFT");
			logger_.setDataInclusao(LocalDateTime.now());
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
