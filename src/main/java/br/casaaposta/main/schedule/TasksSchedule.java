package br.casaaposta.main.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.casaaposta.main.service.FutVirtualServiceEuroCup;
import br.casaaposta.main.service.FutVirtualServicePremier;
import br.casaaposta.main.service.FutVirtualServiceSuperLeague;
import br.casaaposta.main.service.FutVirtualServiceWorldCup;

@Component
public class TasksSchedule {

	@Autowired
	private FutVirtualServiceEuroCup euroCupService;
	@Autowired
	private FutVirtualServicePremier premierCupService;
	@Autowired
	private FutVirtualServiceWorldCup worldCupService;
	@Autowired
	private FutVirtualServiceSuperLeague superCupService;
	
	@Scheduled(fixedDelay = 600000)
	@Async
	public void ObterResultadoFTEuroCopa() {
	
		System.out.println("USANDO SCHEDULE");
		euroCupService.setLiga();
		premierCupService.setLiga();
		worldCupService.setLiga();
		superCupService.setLiga();
		
		euroCupService.obterResultadoFT();
		euroCupService.obterResultadoHT();
		euroCupService.obterResultadoOver25();
		euroCupService.obterResultadoOver35();
		euroCupService.obterResultadoUnder05();
		euroCupService.obterResultadoUnder15();
		euroCupService.obterResultadoCasa();
		euroCupService.obterResultadoEmpate();
		euroCupService.obterResultadoVisitante();
		euroCupService.obterResultadoAmbasMarcam();

		premierCupService.obterResultadoFT();
		premierCupService.obterResultadoHT();
		premierCupService.obterResultadoOver25();
		premierCupService.obterResultadoOver35();
		premierCupService.obterResultadoUnder05();
		premierCupService.obterResultadoUnder15();
		premierCupService.obterResultadoCasa();
		premierCupService.obterResultadoEmpate();
		premierCupService.obterResultadoVisitante();
		premierCupService.obterResultadoAmbasMarcam();
		
		worldCupService.obterResultadoFT();
		worldCupService.obterResultadoHT();
		worldCupService.obterResultadoOver25();
		worldCupService.obterResultadoOver35();
		worldCupService.obterResultadoUnder05();
		worldCupService.obterResultadoUnder15();
		worldCupService.obterResultadoCasa();
		worldCupService.obterResultadoEmpate();
		worldCupService.obterResultadoVisitante();
		worldCupService.obterResultadoAmbasMarcam();
		
		superCupService.obterResultadoFT();
		superCupService.obterResultadoHT();
		superCupService.obterResultadoOver25();
		superCupService.obterResultadoOver35();
		superCupService.obterResultadoUnder05();
		superCupService.obterResultadoUnder15();
		superCupService.obterResultadoCasa();
		superCupService.obterResultadoEmpate();
		superCupService.obterResultadoVisitante();
		superCupService.obterResultadoAmbasMarcam();
	}
	
	@Scheduled(fixedDelay = 300000)
	@Async
	public void ObterCookieReset() {
	
		System.out.println("Reset Cookie");
		euroCupService.setLiga();
		euroCupService.obterResetCookie();

	}
	
	
}
