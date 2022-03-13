package br.casaaposta.main.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;

import br.casaaposta.main.bind.FutServiceCast;
import br.casaaposta.main.entity.Log;
import br.casaaposta.main.entity.TipoResultados;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.repository.TipoResultadosOddsRepository;
import br.casaaposta.main.service.FutVirtualServiceEuroCup;

@Controller
public class CommonController {
	
	@Autowired
	FutVirtualServiceEuroCup futService_;
	@Autowired
	LogRepository logRepository_;
	@Autowired
	TipoResultadosOddsRepository tipoResultadosOddsRepository_;
	Log logger_ = new Log();
	private FutServiceCast futServiceCast_ = new FutServiceCast();

	

	public void setResultadoTipo() {
		
		try {
			List<TipoResultados> results = tipoResultadosOddsRepository_.findAll();
			if(results.isEmpty()) {
				tipoResultadosOddsRepository_.saveAllAndFlush(futServiceCast_.preencheListaResultado());			
			}
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao executar o método, CommonController.setResultadoTipo");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository_.save(logger_);
		}
		
	
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
	
}
