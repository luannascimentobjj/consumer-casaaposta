package br.casaaposta.main.controller;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;

import br.casaaposta.main.entity.Log;
import br.casaaposta.main.entity.Odds;
import br.casaaposta.main.entity.OddsPremierCup;
import br.casaaposta.main.entity.Resultado;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.repository.OddsPremierCupRepository;
import br.casaaposta.main.repository.ResultadoRepository;
import br.casaaposta.main.service.FutVirtualServicePremier;

@Controller
public class FutVirtualPremierCupController {
	
	@Autowired
	FutVirtualServicePremier futService_;
	@Autowired
	OddsPremierCupRepository oddsRepository_;
	@Autowired
	LogRepository logRepository_;
	@Autowired 
	ResultadoRepository resultadoRepository_;
	Log logger_ = new Log();
	

	@Async
	public CompletableFuture<String> obterResultadoUnder05() {
		
		try {
			List<OddsPremierCup> listaUnder05 =  futService_.callServiceResultadoUnder05();
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
			List<OddsPremierCup> listaUnder15 = futService_.callServiceResultadoUnder15();
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
			List<OddsPremierCup> listaOver25 =  futService_.callServiceResultadoOver25();
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
			List<OddsPremierCup> listaOver35 =  futService_.callServiceResultadoOver35();
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
			List<OddsPremierCup> listaCasa =  futService_.callServiceResultadoCasa();
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
			List<OddsPremierCup> listaEmpate =  futService_.callServiceResultadoEmpate();
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
			List<OddsPremierCup> listaVisitante =  futService_.callServiceResultadoVisitante();
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
			List<OddsPremierCup> listaAmbasMarcam =  futService_.callServiceResultadoAmbasMarcam();
			salvarResultadoAmbasMarcam(listaAmbasMarcam);
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoAmbasMarcam");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}
		return null;

		
	}
	
	
	
	
	
	public void salvarResultadoUnder05(List<OddsPremierCup> listUnder05) {
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
	
	public void salvarResultadoUnder15(List<OddsPremierCup> listUnder15) {
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
	
	public void salvarResultadoOver25(List<OddsPremierCup> listOver25) {
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
	public void salvarResultadoOver35(List<OddsPremierCup> listOver35) {
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
	public void salvarResultadoCasa(List<OddsPremierCup> listCasa) {
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
	public void salvarResultadoEmpate(List<OddsPremierCup> listEmpate) {
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
	public void salvarResultadoVisitante(List<OddsPremierCup> listVisitante) {
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
	public void salvarResultadoAmbasMarcam(List<OddsPremierCup> listAmbasMarcam) {
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
	
}
