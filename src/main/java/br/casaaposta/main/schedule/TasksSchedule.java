package br.casaaposta.main.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.casaaposta.main.service.FutVirtualServiceEuroCup;

@Component
public class TasksSchedule {

	@Autowired
	private FutVirtualServiceEuroCup euroCupService;
	
	@Scheduled(fixedDelay = 120000)
	@Async
	public void ObterResultadoFTEuroCopa() {
	
		System.out.println("USANDO SCHEDULE");
		//euroCupService.obterResultadoFT();

	}
	
	
}
