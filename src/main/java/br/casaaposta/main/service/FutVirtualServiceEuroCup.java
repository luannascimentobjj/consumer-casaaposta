package br.casaaposta.main.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;

import br.casaaposta.main.bind.FutServiceBinder;
import br.casaaposta.main.entity.Liga;
import br.casaaposta.main.entity.Log;
import br.casaaposta.main.entity.Odds;
import br.casaaposta.main.entity.Resultado;
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
	private Log logger_;

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

	public void obterResultadoFT() {
		String resultadoTipo = "FT";
		try {
			FutServiceBinder futBusiness = new FutServiceBinder();

			Mono<Object> response = this.webClientResultadoFT.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();

			List<Resultado> r = futBusiness.bindResultado(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);
				if (result.getTollTip() != null) {
					Resultado r1 = resultadoRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(
							result.getTollTip(), result.getMinuto(), result.getHora(), resultadoTipo);
					if (r1 == null) {
						resultadoRepository.save(result);
					}
				}
			});

		} catch (Exception e) {

			this.logger_.setStackTrace(e.getMessage());
			this.logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoFT");
			this.logger_.setDataInclusao(LocalTime.now());
			logRepository.save(this.logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			return;
		}

	};

	public void obterResultadoHT() {
		String resultadoTipo = "HT";
		try {

			FutServiceBinder futBusiness = new FutServiceBinder();

			Mono<Object> response = this.webClientResultadoHT.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();

			List<Resultado> r = futBusiness.bindResultado(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);
				if (result.getTollTip() != null) {
					Resultado r1 = resultadoRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(
							result.getTollTip(), result.getMinuto(), result.getHora(), resultadoTipo);
					if (r1 == null) {
						resultadoRepository.save(result);
					}
				}
			});

		} catch (Exception e) {
			this.logger_.setStackTrace(e.getMessage());
			this.logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoHT");
			this.logger_.setDataInclusao(LocalTime.now());
			logRepository.save(this.logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			return;
		}

	};

	public void obterResultadoUnder05() {

		String resultadoTipo = "Under05";
		try {
			FutServiceBinder futBusiness = new FutServiceBinder();

			Mono<Object> response = this.webClientUnder05.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();

			List<Odds> r = futBusiness.bindOdds(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);
				if (result.getTollTip() != null) {
					Odds r1 = oddsRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(result.getTollTip(),
							result.getMinuto(), result.getHora(), resultadoTipo);
					if (r1 == null) {
						oddsRepository.save(result);
					}
				}
			});

		} catch (Exception e) {

			this.logger_.setStackTrace(e.getMessage());
			this.logger_
					.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoUnder05");
			this.logger_.setDataInclusao(LocalTime.now());
			logRepository.save(this.logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			return;
		}

	};

	public void obterResultadoUnder15() {

		String resultadoTipo = "Under15";
		try {
			FutServiceBinder futBusiness = new FutServiceBinder();

			Mono<Object> response = this.webClientUnder15.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();

			List<Odds> r = futBusiness.bindOdds(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);
				if (result.getTollTip() != null) {
					Odds r1 = oddsRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(result.getTollTip(),
							result.getMinuto(), result.getHora(), resultadoTipo);
					if (r1 == null) {
						oddsRepository.save(result);
					}
				}
			});

		} catch (Exception e) {
			this.logger_.setStackTrace(e.getMessage());
			this.logger_
					.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoUnder15");
			this.logger_.setDataInclusao(LocalTime.now());
			logRepository.save(this.logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			return;
		}

	};

	public void obterResultadoOver25() {

		String resultadoTipo = "Over25";
		try {
			FutServiceBinder futBusiness = new FutServiceBinder();

			Mono<Object> response = this.webClientOver25.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();

			List<Odds> r = futBusiness.bindOdds(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);
				if (result.getTollTip() != null) {
					Odds r1 = oddsRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(result.getTollTip(),
							result.getMinuto(), result.getHora(), resultadoTipo);
					if (r1 == null) {
						oddsRepository.save(result);
					}
				}
			});

		} catch (Exception e) {
			this.logger_.setStackTrace(e.getMessage());
			this.logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoOver25");
			this.logger_.setDataInclusao(LocalTime.now());
			logRepository.save(this.logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			return;
		}

	};

	public void obterResultadoOver35() {
		String resultadoTipo = "Over35";
		try {
			FutServiceBinder futBusiness = new FutServiceBinder();

			Mono<Object> response = this.webClientOver35.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();

			List<Odds> r = futBusiness.bindOdds(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);
				if (result.getTollTip() != null) {
					Odds r1 = oddsRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(result.getTollTip(),
							result.getMinuto(), result.getHora(), resultadoTipo);
					if (r1 == null) {
						oddsRepository.save(result);
					}
				}
			});

		} catch (Exception e) {
			this.logger_.setStackTrace(e.getMessage());
			this.logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoOver35");
			this.logger_.setDataInclusao(LocalTime.now());
			logRepository.save(this.logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			return;
		}

	};

	public void obterResultadoCasa() {

		String resultadoTipo = "Casa";
		try {
			FutServiceBinder futBusiness = new FutServiceBinder();

			Mono<Object> response = this.webClientCasa.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();

			List<Odds> r = futBusiness.bindOdds(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);
				if (result.getTollTip() != null) {
					Odds r1 = oddsRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(result.getTollTip(),
							result.getMinuto(), result.getHora(), resultadoTipo);
					if (r1 == null) {
						oddsRepository.save(result);
					}
				}
			});

		} catch (Exception e) {
			this.logger_.setStackTrace(e.getMessage());
			this.logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoCasa");
			this.logger_.setDataInclusao(LocalTime.now());
			logRepository.save(this.logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			return;
		}

	};

	public void obterResultadoEmpate() {

		String resultadoTipo = "Empate";
		try {
			FutServiceBinder futBusiness = new FutServiceBinder();

			Mono<Object> response = this.webClientEmpate.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();

			List<Odds> r = futBusiness.bindOdds(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);
				if (result.getTollTip() != null) {
					Odds r1 = oddsRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(result.getTollTip(),
							result.getMinuto(), result.getHora(), resultadoTipo);
					if (r1 == null) {
						oddsRepository.save(result);
					}
				}
			});

		} catch (Exception e) {
			this.logger_.setStackTrace(e.getMessage());
			this.logger_.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoEmpate");
			this.logger_.setDataInclusao(LocalTime.now());
			logRepository.save(this.logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			return;
		}

	};

	public void obterResultadoVisitante() {

		String resultadoTipo = "Visitante";
		try {
			FutServiceBinder futBusiness = new FutServiceBinder();

			Mono<Object> response = this.webClientVisitante.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();

			List<Odds> r = futBusiness.bindOdds(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);
				if (result.getTollTip() != null) {
					Odds r1 = oddsRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(result.getTollTip(),
							result.getMinuto(), result.getHora(), resultadoTipo);
					if (r1 == null) {
						oddsRepository.save(result);
					}
				}
			});

		} catch (Exception e) {
			this.logger_.setStackTrace(e.getMessage());
			this.logger_
					.setError("Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoVisitante");
			this.logger_.setDataInclusao(LocalTime.now());
			logRepository.save(this.logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			return;
		}

	};

	public void obterResultadoAmbasMarcam() {

		String resultadoTipo = "AmbasMarcam";
		try {
			FutServiceBinder futBusiness = new FutServiceBinder();

			Mono<Object> response = this.webClientAmbasMarcam.get().retrieve().bodyToMono(Object.class);

			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();

			List<Odds> r = futBusiness.bindOdds(objects, resultadoTipo);
			r.forEach(result -> {
				result.setCodLiga(this.liga);
				if (result.getTollTip() != null) {
					Odds r1 = oddsRepository.findByTollTipAndMinutoAndHoraAndResultadoTipo(result.getTollTip(),
							result.getMinuto(), result.getHora(), resultadoTipo);
					if (r1 == null) {
						oddsRepository.save(result);
					}
				}
			});

		} catch (Exception e) {
			this.logger_.setStackTrace(e.getMessage());
			this.logger_.setError(
					"Erro ao coletar informações no site, FutVirtualServiceEuroCup.obterResultadoAmbasMarcam");
			this.logger_.setDataInclusao(LocalTime.now());
			logRepository.save(this.logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			return;
		}

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
