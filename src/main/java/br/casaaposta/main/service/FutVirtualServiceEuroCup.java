package br.casaaposta.main.service;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.casaaposta.main.bind.FutServiceBinder;
import br.casaaposta.main.bind.FutServiceCast;
import br.casaaposta.main.entity.Liga;
import br.casaaposta.main.entity.Log;
import br.casaaposta.main.entity.OddsEuroCup;
import br.casaaposta.main.entity.Resultado;
import br.casaaposta.main.model.OddsModel;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.repository.ResultadoRepository;
import br.casaaposta.main.util.UrlUtils;
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
	UrlUtils urls;

	@Autowired
	ResultadoRepository resultadoRepository;
	@Autowired
	LogRepository logRepository;
	private FutServiceCast futServiceCast_ = new FutServiceCast();
	private Log logger_ = new Log();
	private FutServiceBinder futServiceBinder_ = new FutServiceBinder();

	public FutVirtualServiceEuroCup(WebClient.Builder webClientBuilder) {
		webClientBuilder.defaultHeaders(httpHeaders -> {
			httpHeaders.set("Cookie", UrlUtils.Auth);
			httpHeaders.set("User-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36");
			httpHeaders.set("Accept-Language", "pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7,pl;q=0.6,it;q=0.5,fr;q=0.4");
			httpHeaders.set("Accept-Encoding", "gzip, deflate, br");
			httpHeaders.set("Accept", "application/json, text/plain, */*");
			httpHeaders.setConnection("keep-alive");
		});

		this.webClientUnder15 = webClientBuilder
				.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseUnder15FinalUrl).build();
		this.webClientUnder05 = webClientBuilder
				.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseUnder05FinalUrl).build();
		this.webClientOver25 = webClientBuilder.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseOver25FinalUrl)
				.build();
		this.webClientOver35 = webClientBuilder.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseOver35FinalUrl)
				.build();
		this.webClientResultadoFT = webClientBuilder.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseFtFinalUrl)
				.build();
		this.webClientResultadoHT = webClientBuilder.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseHtFinalUrl)
				.build();
		this.webClientCasa = webClientBuilder.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseCasaFinalUrl)
				.build();
		this.webClientEmpate = webClientBuilder.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseEmpateFinalUrl)
				.build();
		this.webClientVisitante = webClientBuilder
				.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseVisitanteFinalUrl).build();
		this.webClientAmbasMarcam = webClientBuilder
				.baseUrl(UrlUtils.baseUrl + idCompetition + UrlUtils.baseAmbasMarcamFinalUrl).build();

	}

	public void obterResetCookie() {
		try {
			
			Mono<Object> response = this.webClientResultadoFT.get()
					.uri(urls.baseUrl + idCompetition + UrlUtils.baseResetCookieUrl).retrieve()
					.bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
		} catch (Exception e) {
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			return;
		}

	};


	public List<Resultado> callServiceResultadoFT(Liga liga) {
		String resultadoTipo = "FT";
		try {

			Mono<Object> response = this.webClientResultadoFT.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado FT");
			List<Resultado> r = futServiceBinder_.bindResultado(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(liga);
			});
			return r;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoFT");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;

	};

	public List<Resultado> callServiceResultadoHT(Liga liga) {
		String resultadoTipo = "HT";
		try {
			Mono<Object> response = this.webClientResultadoHT.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado HT");
			List<Resultado> r = futServiceBinder_.bindResultado(objects, resultadoTipo);
			System.out.println(r.size());
			r.forEach(result -> {
				result.setCodLiga(liga);
			});
			return r;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoHT");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;

	};



	public List<OddsEuroCup> callServiceUnder05(Liga liga) {

		String resultadoTipo = "Under05";
		try {
			
			Mono<Object> response = this.webClientUnder05.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado Under05");
			List<OddsModel> r = futServiceBinder_.bindOdds(objects, resultadoTipo);
			List <OddsEuroCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast_.castListOddsEuroCup(r, liga);
			return listOddsToReturn;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.callServiceUnder05");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;

	};
	
	
	public List<OddsEuroCup> callServiceUnder15(Liga liga) {
		String resultadoTipo = "Under15";
		try {
			Mono<Object> response = this.webClientUnder15.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado Under15");
			List<OddsModel> r = futServiceBinder_.bindOdds(objects, resultadoTipo);
			List <OddsEuroCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast_.castListOddsEuroCup(r, liga);
			return listOddsToReturn;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoUnder15");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;
	};


	public List<OddsEuroCup> callServiceOver25(Liga liga) {
		String resultadoTipo = "Over25";
		try {
			
			Mono<Object> response = this.webClientOver25.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado Over25");
			List<OddsModel> r = futServiceBinder_.bindOdds(objects, resultadoTipo);
			List <OddsEuroCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast_.castListOddsEuroCup(r, liga);
			return listOddsToReturn;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoOver25");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;
	};


	public List<OddsEuroCup> callServiceOver35(Liga liga) {
		String resultadoTipo = "Over35";
		try {
			
			Mono<Object> response = this.webClientOver35.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado Over35");
			List<OddsModel> r = futServiceBinder_.bindOdds(objects, resultadoTipo);
			List <OddsEuroCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast_.castListOddsEuroCup(r, liga);
			return listOddsToReturn;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoOver35");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;
	};


	public List<OddsEuroCup> callServiceCasa(Liga liga) {

		String resultadoTipo = "Casa";
		try {
			
			Mono<Object> response = this.webClientCasa.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado Casa");
			List<OddsModel> r = futServiceBinder_.bindOdds(objects, resultadoTipo);
			List <OddsEuroCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast_.castListOddsEuroCup(r, liga);
			return listOddsToReturn;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoCasa");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			return null;
		}

	};

	
	public List<OddsEuroCup> callServiceEmpate(Liga liga) {
		String resultadoTipo = "Empate";
		try {
			
			Mono<Object> response = this.webClientEmpate.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado empate");
			List<OddsModel> r = futServiceBinder_.bindOdds(objects, resultadoTipo);
			List <OddsEuroCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast_.castListOddsEuroCup(r, liga);
			return listOddsToReturn;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoEmpate");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;
	};
	
	public List<OddsEuroCup> callServiceVisitante(Liga liga) {
		String resultadoTipo = "Visitante";
		try {
			
			Mono<Object> response = this.webClientVisitante.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado Visitante");
			List<OddsModel> r = futServiceBinder_.bindOdds(objects, resultadoTipo);
			List <OddsEuroCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast_.castListOddsEuroCup(r, liga);
			return listOddsToReturn;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoVisitante");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;
	};

	
	public List<OddsEuroCup> callServiceAmbasMarcam(Liga liga) {
		String resultadoTipo = "AmbasMarcam";
		try {
 			
			Mono<Object> response = this.webClientAmbasMarcam.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado AmbasMarcam");
			List<OddsModel> r = futServiceBinder_.bindOdds(objects, resultadoTipo);
			List <OddsEuroCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast_.castListOddsEuroCup(r, liga);
			return listOddsToReturn;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoAmbasMarcam");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;
	};

}
