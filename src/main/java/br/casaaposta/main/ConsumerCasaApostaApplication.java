package br.casaaposta.main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class ConsumerCasaApostaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerCasaApostaApplication.class, args);
	}


}
