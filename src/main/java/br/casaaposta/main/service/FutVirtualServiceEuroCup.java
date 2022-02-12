package br.casaaposta.main.service;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.casaaposta.main.entity.Log;
import br.casaaposta.main.entity.Resultado;
import br.casaaposta.main.model.ResultadoModel;
import br.casaaposta.main.repository.LigaRepository;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.repository.OddsRepository;
import br.casaaposta.main.repository.ResultadoRepository;
import br.casaaposta.main.util.UrlUtils;

@Service
public class FutVirtualServiceEuroCup {

	private final WebClient webClientUnder15;
	private final WebClient webClientUnder05;
	private final WebClient webClientOver25;
	private final WebClient webClientOver35;
	private final WebClient webClientResultadoFT;
	private final WebClient webClientResultadoHT;
	private final WebClient webClientCasa;
	private final WebClient webClientEmpate;
	private final WebClient webClientVisitante;
	private final WebClient webClientAmbasMarcam;
	
	UrlUtils urls;
	@Autowired 
	private LigaRepository ligaRepository;
	
	@Autowired 
	private OddsRepository oddsRepository;
	
	@Autowired 
	ResultadoRepository resultadoRepository;
		
	@Autowired 
	LogRepository logRepository;
	
	
	
	 public FutVirtualServiceEuroCup(WebClient.Builder webClientBuilder) {
		 webClientBuilder.defaultHeaders(httpHeaders -> {
			    httpHeaders.set("Cookie", UrlUtils.Auth);
			    httpHeaders.set("User-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36");
			    httpHeaders.set("Accept-Language", "pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7,pl;q=0.6,it;q=0.5,fr;q=0.4");
			    httpHeaders.set("Accept-Encoding","gzip, deflate, br");
			    httpHeaders.set("Accept","application/json, text/plain, */*");
			    httpHeaders.setConnection("keep-alive");
			});
		this.webClientUnder15 = webClientBuilder.baseUrl(UrlUtils.baseUrl + UrlUtils.idEuroCup + UrlUtils.baseUnder15FinalUrl).build();
		this.webClientUnder05 = webClientBuilder.baseUrl(UrlUtils.baseUrl + UrlUtils.idEuroCup + UrlUtils.baseUnder05FinalUrl).build();
		this.webClientOver25 = webClientBuilder.baseUrl(UrlUtils.baseUrl + UrlUtils.idEuroCup + UrlUtils.baseOver25FinalUrl).build();
		this.webClientOver35 = webClientBuilder.baseUrl(UrlUtils.baseUrl + UrlUtils.idEuroCup + UrlUtils.baseOver35FinalUrl).build();
		this.webClientResultadoFT = webClientBuilder.baseUrl(UrlUtils.baseUrl + UrlUtils.idEuroCup + UrlUtils.baseFtFinalUrl).build();
		this.webClientResultadoHT = webClientBuilder.baseUrl(UrlUtils.baseUrl + UrlUtils.idEuroCup + UrlUtils.baseHtFinalUrl).build();
		this.webClientCasa = webClientBuilder.baseUrl(UrlUtils.baseUrl + UrlUtils.idEuroCup + UrlUtils.baseCasaFinalUrl).build();
		this.webClientEmpate = webClientBuilder.baseUrl(UrlUtils.baseUrl + UrlUtils.idEuroCup + UrlUtils.baseEmpateFinalUrl).build();
		this.webClientVisitante = webClientBuilder.baseUrl(UrlUtils.baseUrl + UrlUtils.idEuroCup + UrlUtils.baseVisitanteFinalUrl).build();
		this.webClientAmbasMarcam = webClientBuilder.baseUrl(UrlUtils.baseUrl + UrlUtils.idEuroCup + UrlUtils.baseAmbasMarcamFinalUrl).build();
		
	}
	
	
	public Resultado obterResultadoFT () {
		
		try {
		
			Resultado resultado = new Resultado();
			resultado = (Resultado) this.webClientResultadoFT.get();
			resultadoRepository.save(resultado);
			return resultado;
			
		} catch (Exception e) {
			Log log = new Log();
			log.setDataInclusao(LocalTime.now());
			log.setStackTrace(e.getMessage());
			log.setError("Erro ao obter resultados na Api do FutVirtual");
		    logRepository.save(log);
			System.out.println("Erro ao coletar informações no site");
			return null;
		}
				
	};
	
	
	public ResultadoModel obterResultadoUnder15 () {
		
		try {
		
			return (ResultadoModel) this.webClientUnder15.get();
			
		} catch (Exception e) {
			System.out.println("Erro ao coletar informações no site");
			return null;
		}
				
	};
					
}
