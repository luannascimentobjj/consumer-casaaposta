package br.casaaposta.main.controller;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.casaaposta.main.entity.Log;
import br.casaaposta.main.entity.Odds;
import br.casaaposta.main.entity.Resultado;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.repository.OddsRepository;
import br.casaaposta.main.repository.ResultadoRepository;
import br.casaaposta.main.service.FutVirtualServiceEuroCup;

public class FutVirtualEuroCupController {
	
	@Autowired
	FutVirtualServiceEuroCup futService_;
	@Autowired
	OddsRepository oddsRepository_;
	@Autowired
	LogRepository logRepository_;
	@Autowired 
	ResultadoRepository resultadoRepository_;
	Log logger_ = new Log();
	

	public void obterResultadoUnder05() {
		
		try {
			
			List<Odds> listaUnder05 =  futService_.callServiceUnder05();
			salvarResultadoUnder05(listaUnder05);
			
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoUnder05");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}

		
	}
	
	public void obterResultadoHT() {
		
		try {
			
			List<Resultado> listaResultadoHT =  futService_.callServiceResultadoHT();
			salvarResultadoHT(listaResultadoHT);
			
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoHT");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}

		
	}
	
	public void obterResultadoFT() {
		
		try {
			
			List<Resultado> listaResultadoHT =  futService_.callServiceResultadoFT();
			salvarResultadoHT(listaResultadoHT);
			
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, FutVirtualServiceEuroCup.obterResultadoFT");
			logger_.setDataInclusao(LocalTime.now());
			logRepository_.save(logger_);
		}

		
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
		oddsRepository_.saveAll(listUnder05);
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
	
	
	
	public void salvarResultadoHT(List<Resultado> listResultado) {
		
		try {
		
		Date d = new Date();
		Long time = d.getTime();
		System.out.println("Início do Save banco: Total da Execução - HT " + LocalTime.now());
		resultadoRepository_.saveAll(listResultado);
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
		resultadoRepository_.saveAll(listResultado);
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
