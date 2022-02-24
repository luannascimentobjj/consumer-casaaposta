package br.casaaposta.main.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import br.casaaposta.main.entity.Log;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.repository.OddsRepository;
import br.casaaposta.main.repository.ResultadoRepository;
import br.casaaposta.main.service.FutVirtualServicePremier;

@Controller
public class FutVirtualPremierController {
	
	
	@Autowired
	FutVirtualServicePremier futService_;
	@Autowired
	OddsRepository oddsRepository_;
	@Autowired
	LogRepository logRepository_;
	@Autowired 
	ResultadoRepository resultadoRepository_;
	Log logger_ = new Log();

	
	
	
}
