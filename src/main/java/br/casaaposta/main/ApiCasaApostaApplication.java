package br.casaaposta.main;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@Configuration
public class ApiCasaApostaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCasaApostaApplication.class, args);
	}

	  
	public Executor asyncExecutor() {
        final ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(1);
        taskExecutor.setMaxPoolSize(4);
        taskExecutor.setThreadNamePrefix("taskExecutor");
        taskExecutor.initialize();
        return taskExecutor;
    }
}
