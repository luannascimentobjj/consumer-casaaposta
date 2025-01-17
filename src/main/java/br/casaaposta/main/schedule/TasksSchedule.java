package br.casaaposta.main.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.casaaposta.main.controller.CommonController;
import br.casaaposta.main.controller.FutVirtualEuroCupController;
import br.casaaposta.main.controller.FutVirtualPremierCupController;
import br.casaaposta.main.controller.FutVirtualSuperCupController;
import br.casaaposta.main.controller.FutVirtualWorldCupController;


@Component
public class TasksSchedule {

	@Autowired
	private FutVirtualSuperCupController superCupController;
	@Autowired
	private FutVirtualWorldCupController worldCupController;
	@Autowired
	private FutVirtualEuroCupController euroCupController;
	@Autowired 
	FutVirtualPremierCupController premierCupController;
	@Autowired
	CommonController commonController;
	
	@Scheduled(fixedDelay = 600000)
	public void scheduleEuroCup() {
	
		System.out.println("Iniciou Schedule EuroCopa");
		euroCupController.setLiga();
		euroCupController.obterResultadoFT();
		euroCupController.obterResultadoHT();
		euroCupController.obterResultadoUnder05();
		euroCupController.obterResultadoAmbasMarcam();
		euroCupController.obterResultadoOver25();
		euroCupController.obterResultadoOver35();
		euroCupController.obterResultadoUnder15();
		euroCupController.obterResultadoCasa();
		euroCupController.obterResultadoEmpate();
		euroCupController.obterResultadoVisitante();
	
	}
	

	@Scheduled(fixedDelay = 600000)
	public void schedulePremierCup() {
		System.out.println("Iniciou Schedule Premier Copa");
		premierCupController.setLiga();
		premierCupController.obterResultadoFT();
		premierCupController.obterResultadoHT();
		premierCupController.obterResultadoOver25();
		premierCupController.obterResultadoOver35();
		premierCupController.obterResultadoUnder05();
		premierCupController.obterResultadoUnder15();
		premierCupController.obterResultadoCasa();
		premierCupController.obterResultadoEmpate();
		premierCupController.obterResultadoVisitante();
		premierCupController.obterResultadoAmbasMarcam();
	}
	

	
	
	@Scheduled(fixedDelay = 600000)
	public void scheduleWorldCup() {
		System.out.println("Iniciou Schedule World Copa");
		worldCupController.setLiga();
		worldCupController.obterResultadoFT();
		worldCupController.obterResultadoHT();
		worldCupController.obterResultadoOver25();
		worldCupController.obterResultadoOver35();
		worldCupController.obterResultadoUnder05();
		worldCupController.obterResultadoUnder15();
		worldCupController.obterResultadoCasa();
		worldCupController.obterResultadoEmpate();
		worldCupController.obterResultadoVisitante();
		worldCupController.obterResultadoAmbasMarcam();
		System.out.println("Finalizou Schedule World Copa");
	}
	
	
	@Scheduled(fixedDelay = 600000)
	public void scheduleSuperCup() {
		System.out.println("Iniciou Schedule Super Copa");
		superCupController.setLiga();
		superCupController.obterResultadoFT();
		superCupController.obterResultadoHT();
		superCupController.obterResultadoOver25();
		superCupController.obterResultadoOver35();
		superCupController.obterResultadoUnder05();
		superCupController.obterResultadoUnder15();
		superCupController.obterResultadoCasa();
		superCupController.obterResultadoEmpate();
		superCupController.obterResultadoVisitante();
		superCupController.obterResultadoAmbasMarcam();
	}
	
	@Scheduled(fixedDelay = 120000)
	@Async
	public void ObterCookieReset() {
	
		System.out.println("Reset Cookie");
		commonController.resetarCookie();

	}
	
	
	@Scheduled(fixedDelay = 600000)
	@Async
	public void checkListResultadosTipo() {
	
		System.out.println("Preenche Lista Resultados Tipos");
		commonController.setResultadoTipo();

	}
	
	
}
