package br.casaaposta.main.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;

import br.casaaposta.main.model.ResultadoModel;
import br.casaaposta.main.repository.LigaRepository;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.repository.OddsRepository;
import br.casaaposta.main.repository.ResultadoRepository;
import br.casaaposta.main.util.UrlUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
	private final String idCompetition = UrlUtils.idEuroCup;
	
	private final WebClient webClient;
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
		this.webClient = webClientBuilder.build();
		this.webClientUnder15 = webClientBuilder.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseUnder15FinalUrl).build();
		this.webClientUnder05 = webClientBuilder.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseUnder05FinalUrl).build();
		this.webClientOver25 = webClientBuilder.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseOver25FinalUrl).build();
		this.webClientOver35 = webClientBuilder.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseOver35FinalUrl).build();
		this.webClientResultadoFT = webClientBuilder.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseFtFinalUrl).build();
		this.webClientResultadoHT = webClientBuilder.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseHtFinalUrl).build();
		this.webClientCasa = webClientBuilder.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseCasaFinalUrl).build();
		this.webClientEmpate = webClientBuilder.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseEmpateFinalUrl).build();
		this.webClientVisitante = webClientBuilder.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseVisitanteFinalUrl).build();
		this.webClientAmbasMarcam = webClientBuilder.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseAmbasMarcamFinalUrl).build();
		
	}
	
	
	public Object obterResultadoFT () {
		
		try {
		
			return (Object) this.webClientResultadoFT.get();
			
		} catch (Exception e) {
			System.out.println("Erro ao coletar informações no site");
			return null;
		}
				
	};
	
	public Object obterResultadoHT () {
		
		try {
			Mono<Object> response = this.webClientResultadoHT.get().retrieve()
				    .bodyToMono(Object.class);
			
			Object objects = response.block();
				  
			return objects;
			//return list;
//			STRING X  = "";
//			RETURN (OBJECT) THIS.WEBCLIENTRESULTADOHT.GET();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			return null;
		}
				
	};
	
	public Object obterResultadoUnder05 () {
		
		try {
		
			return (Object) this.webClientUnder05.get();
			
		} catch (Exception e) {
			System.out.println("Erro ao coletar informações no site");
			return null;
		}
				
	};
		
	
	public Object obterResultadoUnder15 () {
		
		try {
		
			return (Object) this.webClientUnder15.get();
			
		} catch (Exception e) {
			System.out.println("Erro ao coletar informações no site");
			return null;
		}
				
	};
	
	public Object obterResultadoOver25 () {
			
			try {
			
				return (Object) this.webClientOver25.get();
				
			} catch (Exception e) {
				System.out.println("Erro ao coletar informações no site");
				return null;
			}
					
		};
		public Object obterResultadoOver35 () {
			
			try {
			
				return (Object) this.webClientOver35.get();
				
			} catch (Exception e) {
				System.out.println("Erro ao coletar informações no site");
				return null;
			}
					
		};
		
		public Object obterResultadoCasa () {
			
			try {
			
				return (Object) this.webClientCasa.get();
				
			} catch (Exception e) {
				System.out.println("Erro ao coletar informações no site");
				return null;
			}
					
		};
		
		public Object obterResultadoEmpate () {
			
			try {
			
				return (Object) this.webClientEmpate.get();
				
			} catch (Exception e) {
				System.out.println("Erro ao coletar informações no site");
				return null;
			}
					
		};
		
		public Object obterResultadoVisitante () {
			
			try {
			
				return (Object) this.webClientVisitante.get();
				
			} catch (Exception e) {
				System.out.println("Erro ao coletar informações no site");
				return null;
			}
					
		};
		
		public Object obterResultadoAmbasMarcam () {
			
			try {
			
				return (Object) this.webClientAmbasMarcam.get();
				
			} catch (Exception e) {
				System.out.println("Erro ao coletar informações no site");
				return null;
			}
					
		};
					
}
