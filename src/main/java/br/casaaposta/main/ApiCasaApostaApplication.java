package br.casaaposta.main;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.reactive.function.client.WebClient;

import br.casaaposta.main.service.FutVirtualServiceEuroCup;

@SpringBootApplication
public class ApiCasaApostaApplication {

	public static void main(String[] args) {
		System.out.println("opa, passando aqui.");
		SpringApplication.run(ApiCasaApostaApplication.class, args);
		
		WebClient.Builder webClient = WebClient.builder();
		FutVirtualServiceEuroCup fut = new FutVirtualServiceEuroCup(webClient);
		Object o = fut.obterResultadoFT();
		Object o2 = fut.obterResultadoHT();
		Object o3 = fut.obterResultadoEmpate();
		
	}

	@Bean  
    public Executor asyncExecutor() {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(4);
        executor.initialize();
        return executor;
    }
}
