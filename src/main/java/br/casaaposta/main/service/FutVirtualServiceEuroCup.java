package br.casaaposta.main.service;
import java.time.LocalTime;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;


import br.casaaposta.main.bind.FutServiceBinder;
import br.casaaposta.main.entity.Liga;
import br.casaaposta.main.entity.Log;
import br.casaaposta.main.entity.Odds;
import br.casaaposta.main.entity.Resultado;

import br.casaaposta.main.repository.LigaRepository;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.repository.OddsRepository;
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

	private Liga liga;
	@Autowired
	private LigaRepository ligaRepository;
	@Autowired
	private OddsRepository oddsRepository;
	@Autowired
	ResultadoRepository resultadoRepository;
	@Autowired
	LogRepository logRepository;

	private Log logger_ = new Log();

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
		String resultadoTipo = "FT";
		try {
			FutServiceBinder futBusiness = new FutServiceBinder();

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


	public List<Resultado> callServiceResultadoFT() {
		String resultadoTipo = "FT";
		try {

			FutServiceBinder futBusiness = new FutServiceBinder();
			
			Mono<Object> response = this.webClientResultadoFT.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado FT");
			List<Resultado> r = futBusiness.bindResultado(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);

			});
			
			return r;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoFT");
			logger_.setDataInclusao(LocalTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;

	};

	public List<Resultado> callServiceResultadoHT() {
		String resultadoTipo = "HT";
		try {

			FutServiceBinder futBusiness = new FutServiceBinder();
			
			Mono<Object> response = this.webClientResultadoHT.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado HT");
			List<Resultado> r = futBusiness.bindResultado(objects, resultadoTipo);
			System.out.println(r.size());
			r.forEach(result -> {
				result.setCodLiga(this.liga);
			});
			
			return r;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoHT");
			logger_.setDataInclusao(LocalTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;

	};



	public List<Odds> callServiceUnder05() {

		String resultadoTipo = "Under05";
		try {

			FutServiceBinder futBusiness = new FutServiceBinder();
			
			Mono<Object> response = this.webClientUnder05.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado Under05");
			List<Odds> r = futBusiness.bindOdds(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);
			});
			
			return r;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.callServiceUnder05");
			logger_.setDataInclusao(LocalTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;

	};
	
	
	public List<Odds> callServiceUnder15() {

		String resultadoTipo = "Under15";
		try {

			FutServiceBinder futBusiness = new FutServiceBinder();
			
			Mono<Object> response = this.webClientUnder15.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado Under15");
			List<Odds> r = futBusiness.bindOdds(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);

			});
			
			return r;
			
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoUnder15");
			logger_.setDataInclusao(LocalTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;
	};


	public List<Odds> callServiceOver25() {

		String resultadoTipo = "Over25";
		try {

			FutServiceBinder futBusiness = new FutServiceBinder();
			
			Mono<Object> response = this.webClientOver25.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado Over25");
			List<Odds> r = futBusiness.bindOdds(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);
			});

			return r;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoOver25");
			logger_.setDataInclusao(LocalTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;
	};


	public List<Odds> callServiceOver35() {
		String resultadoTipo = "Over35";
		try {

			FutServiceBinder futBusiness = new FutServiceBinder();
			
			Mono<Object> response = this.webClientOver35.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado Over35");
			List<Odds> r = futBusiness.bindOdds(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);

			});

			return r;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoOver35");
			logger_.setDataInclusao(LocalTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;
	};


	public List<Odds> callServiceCasa() {

		String resultadoTipo = "Casa";
		try {

			FutServiceBinder futBusiness = new FutServiceBinder();
			
			Mono<Object> response = this.webClientCasa.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado Casa");
			List<Odds> r = futBusiness.bindOdds(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);

			});
			return r;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoCasa");
			logger_.setDataInclusao(LocalTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			return null;
		}

	};

	
	public List<Odds> callServiceEmpate() {

		String resultadoTipo = "Empate";
		try {

			FutServiceBinder futBusiness = new FutServiceBinder();
			
			Mono<Object> response = this.webClientEmpate.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado empate");
			List<Odds> r = futBusiness.bindOdds(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);

			});
			return r;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoEmpate");
			logger_.setDataInclusao(LocalTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;
	};
	
	public List<Odds> callServiceVisitante() {

		String resultadoTipo = "Visitante";
		try {

			FutServiceBinder futBusiness = new FutServiceBinder();
			
			Mono<Object> response = this.webClientVisitante.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado Visitante");
			List<Odds> r = futBusiness.bindOdds(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);
				
			});
			return r;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoVisitante");
			logger_.setDataInclusao(LocalTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;
	};

	@Async
	public List<Odds> callServiceAmbasMarcam() {

		String resultadoTipo = "AmbasMarcam";
		try {

			FutServiceBinder futBusiness = new FutServiceBinder();
			
			Mono<Object> response = this.webClientAmbasMarcam.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			System.out.println("Retornou do Serviço resultado AmbasMarcam");
			List<Odds> r = futBusiness.bindOdds(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);

			});
			return r;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoAmbasMarcam");
			logger_.setDataInclusao(LocalTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;
	};

	public void setLiga() {
		Optional<Liga> liga = ligaRepository.findByCodLiga(idCompetition);
		if (!liga.isPresent()) {
			Liga l1 = new Liga();
			l1.setNomeLiga("Euro Copa");
			l1.setCodLiga(idCompetition);
			this.liga = ligaRepository.save(l1);
		} else {
			this.liga = liga.get();
		}

	};

}
