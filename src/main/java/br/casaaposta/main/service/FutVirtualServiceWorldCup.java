package br.casaaposta.main.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import br.casaaposta.main.bind.FutServiceBinder;
import br.casaaposta.main.bind.FutServiceCast;
import br.casaaposta.main.entity.Liga;
import br.casaaposta.main.entity.Log;
import br.casaaposta.main.entity.OddsEuroCup;
import br.casaaposta.main.entity.OddsPremierCup;
import br.casaaposta.main.entity.OddsWorldCup;
import br.casaaposta.main.entity.Resultado;
import br.casaaposta.main.model.OddsModel;
import br.casaaposta.main.repository.LigaRepository;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.repository.ResultadoRepository;
import br.casaaposta.main.util.UrlUtils;
import reactor.core.publisher.Mono;

@Service
public class FutVirtualServiceWorldCup {

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
	private final String idCompetition = UrlUtils.idWorldCup;
	UrlUtils urls;

	@Autowired
	ResultadoRepository resultadoRepository;
	@Autowired
	LogRepository logRepository;
	private Log logger_ = new Log();
	private FutServiceCast futServiceCast = new FutServiceCast();
	private FutServiceBinder futServiceBinder = new FutServiceBinder();
	
	
	public FutVirtualServiceWorldCup(WebClient.Builder webClientBuilder) {
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

	
	public List<Resultado> callServiceResultadoFT(Liga liga) {
		String resultadoTipo = "FT";
		try {

			Mono<Object> response = this.webClientResultadoFT.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<Resultado> r = futServiceBinder.bindResultado(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(liga);
			});
			return r;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceWorldCup.obterResultadoFT");
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
			List<Resultado> r = futServiceBinder.bindResultado(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(liga);
			});
			return r;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceWorldCup.obterResultadoHT");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}

		return null;
	};

	
	public List<OddsWorldCup> callServiceResultadoUnder05(Liga liga) {

		String resultadoTipo = "Under05";
		try {

			
			Mono<Object> response = this.webClientUnder05.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, resultadoTipo);
			List <OddsWorldCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsWorldCup(r,liga);
			return listOddsToReturn;


		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceWorldCup.obterResultadoUnder05");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}
		return null;

	};

	
	public List<OddsWorldCup> callServiceResultadoUnder15(Liga liga) {

		String resultadoTipo = "Under15";
		try {
			FutServiceBinder futBusiness = new FutServiceBinder();
			Mono<Object> response = this.webClientUnder15.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, resultadoTipo);
			List <OddsWorldCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsWorldCup(r,liga);
			return listOddsToReturn;



		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceWorldCup.obterResultadoUnder15");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}
		return null;

	};

	
	public List<OddsWorldCup> callServiceResultadoOver25(Liga liga) {

		String resultadoTipo = "Over25";
		try {
			FutServiceBinder futBusiness = new FutServiceBinder();
			Mono<Object> response = this.webClientOver25.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, resultadoTipo);
			List <OddsWorldCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsWorldCup(r,liga);
			return listOddsToReturn;


		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceWorldCup.obterResultadoOver25");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}

		return null;
	};


	public List<OddsWorldCup> callServiceResultadoOver35(Liga liga) {
		String resultadoTipo = "Over35";
		try {
			
			
			Mono<Object> response = this.webClientOver35.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, resultadoTipo);
			List <OddsWorldCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsWorldCup(r,liga);
			return listOddsToReturn;


		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceWorldCup.obterResultadoOver35");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}
		return null;

	};

	
	public List<OddsWorldCup> callServiceResultadoCasa(Liga liga) {

		String resultadoTipo = "Casa";
		try {
			
			
			Mono<Object> response = this.webClientCasa.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, resultadoTipo);
			List <OddsWorldCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsWorldCup(r,liga);
			return listOddsToReturn;


		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceWorldCup.obterResultadoCasa");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}

		return null;
	};

	
	public List<OddsWorldCup> callServiceResultadoEmpate(Liga liga) {

		String resultadoTipo = "Empate";
		try {

			
			Mono<Object> response = this.webClientEmpate.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, resultadoTipo);
			List <OddsWorldCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsWorldCup(r,liga);
			return listOddsToReturn;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceWorldCup.obterResultadoEmpate");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}

		return null;
	};

	
	public List<OddsWorldCup> callServiceResultadoVisitante(Liga liga) {

		String resultadoTipo = "Visitante";
		try {

			
			Mono<Object> response = this.webClientVisitante.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, resultadoTipo);
			List <OddsWorldCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsWorldCup(r,liga);
			return listOddsToReturn;


		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceWorldCup.obterResultadoVisitante");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}
		return null;

	};

	
	public List<OddsWorldCup> callServiceResultadoAmbasMarcam(Liga liga) {

		String resultadoTipo = "AmbasMarcam";
		try {

			
			Mono<Object> response = this.webClientAmbasMarcam.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, resultadoTipo);
			List <OddsWorldCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsWorldCup(r,liga);
			return listOddsToReturn;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError(
					"Erro ao coletar informações no site, FutVirtualServiceWorldCup.obterResultadoAmbasMarcam");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}
		
		return null;

	};


}
