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
import br.casaaposta.main.entity.OddsSuperCup;
import br.casaaposta.main.entity.Resultado;
import br.casaaposta.main.model.OddsModel;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.repository.ResultadoRepository;
import br.casaaposta.main.util.ConstantsUtils;
import reactor.core.publisher.Mono;

@Service
public class FutVirtualServiceSuperCup {

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
	

	@Autowired
	ResultadoRepository resultadoRepository;
	@Autowired
	LogRepository logRepository;
	private Log logger_ = new Log();
	private FutServiceCast futServiceCast = new FutServiceCast();
	private FutServiceBinder futServiceBinder = new FutServiceBinder();
	

	public FutVirtualServiceSuperCup(WebClient.Builder webClientBuilder) {
		webClientBuilder.defaultHeaders(httpHeaders -> {
			httpHeaders.set("Cookie", ConstantsUtils.Auth);
			httpHeaders.set("User-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36");
			httpHeaders.set("Accept-Language", "pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7,pl;q=0.6,it;q=0.5,fr;q=0.4");
			httpHeaders.set("Accept-Encoding", "gzip, deflate, br");
			httpHeaders.set("Accept", "application/json, text/plain, */*");
			httpHeaders.setConnection("keep-alive");
		});

		this.webClientUnder15 = webClientBuilder
				.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idSuperLeagueCup + ConstantsUtils.baseUnder15FinalUrl).build();
		this.webClientUnder05 = webClientBuilder
				.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idSuperLeagueCup + ConstantsUtils.baseUnder05FinalUrl).build();
		this.webClientOver25 = webClientBuilder.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idSuperLeagueCup + ConstantsUtils.baseOver25FinalUrl)
				.build();
		this.webClientOver35 = webClientBuilder.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idSuperLeagueCup + ConstantsUtils.baseOver35FinalUrl)
				.build();
		this.webClientResultadoFT = webClientBuilder.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idSuperLeagueCup + ConstantsUtils.baseFtFinalUrl)
				.build();
		this.webClientResultadoHT = webClientBuilder.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idSuperLeagueCup + ConstantsUtils.baseHtFinalUrl)
				.build();
		this.webClientCasa = webClientBuilder.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idSuperLeagueCup + ConstantsUtils.baseCasaFinalUrl)
				.build();
		this.webClientEmpate = webClientBuilder.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idSuperLeagueCup + ConstantsUtils.baseEmpateFinalUrl)
				.build();
		this.webClientVisitante = webClientBuilder
				.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idSuperLeagueCup + ConstantsUtils.baseVisitanteFinalUrl).build();
		this.webClientAmbasMarcam = webClientBuilder
				.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idSuperLeagueCup + ConstantsUtils.baseAmbasMarcamFinalUrl).build();

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
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceSuperCup.obterResultadoFT");
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
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceSuperCup.obterResultadoHT");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}

		return null;
		
	};

	
	public List<OddsSuperCup> callServiceResultadoUnder05(Liga liga) {

		String resultadoTipo = "Under05";
		try {
			
			Mono<Object> response = this.webClientUnder05.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, resultadoTipo);
			List <OddsSuperCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsSuperCup(r, liga);
			return listOddsToReturn;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceSuperCup.obterResultadoUnder05");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}
		
		return null;

	};

	
	public List<OddsSuperCup> callServiceResultadoUnder15(Liga liga) {

		String resultadoTipo = "Under15";
		try {
			
			Mono<Object> response = this.webClientUnder15.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, resultadoTipo);
			List <OddsSuperCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsSuperCup(r, liga);
			return listOddsToReturn;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceSuperCup.obterResultadoUnder15");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
		
		}

		return null;
	};

	
	public List<OddsSuperCup> callServiceResultadoOver25(Liga liga) {

		String resultadoTipo = "Over25";
		try {
	
			
			Mono<Object> response = this.webClientOver25.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, resultadoTipo);
			List <OddsSuperCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsSuperCup(r, liga);
			return listOddsToReturn;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceSuperCup.obterResultadoOver25");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}
		return null;
	};

	
	public List<OddsSuperCup> callServiceResultadoOver35(Liga liga) {
		String resultadoTipo = "Over35";
		try {

			
			Mono<Object> response = this.webClientOver35.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, resultadoTipo);
			List <OddsSuperCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsSuperCup(r, liga);
			return listOddsToReturn;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceSuperCup.obterResultadoOver35");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}
		return null;
	};

	
	public List<OddsSuperCup> callServiceResultadoCasa(Liga liga) {

		String resultadoTipo = "Casa";
		try {
			
			Mono<Object> response = this.webClientCasa.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, resultadoTipo);
			List <OddsSuperCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsSuperCup(r, liga);
			return listOddsToReturn;

		
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceSuperCup.obterResultadoCasa");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}
		return null;
	};

	
	public List<OddsSuperCup> callServiceResultadoEmpate(Liga liga) {

		String resultadoTipo = "Empate";
		try {
			
			
			Mono<Object> response = this.webClientEmpate.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, resultadoTipo);
			List <OddsSuperCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsSuperCup(r, liga);
			return listOddsToReturn;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServiceSuperCup.obterResultadoEmpate");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}
		return null;
	};

	
	public List<OddsSuperCup> callServiceResultadoVisitante(Liga liga) {

		String resultadoTipo = "Visitante";
		try {
			
			Mono<Object> response = this.webClientVisitante.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, resultadoTipo);
			List <OddsSuperCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsSuperCup(r, liga);
			return listOddsToReturn;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError(
					"Erro ao coletar informações no site, FutVirtualServiceSuperCup.obterResultadoVisitante");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}

		return null;
	};

	public List<OddsSuperCup>  callServiceResultadoAmbasMarcam(Liga liga) {

		String resultadoTipo = "AmbasMarcam";
		try {
			
			Mono<Object> response = this.webClientAmbasMarcam.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, resultadoTipo);
			List <OddsSuperCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsSuperCup(r, liga);
			return listOddsToReturn;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError(
					"Erro ao coletar informações no site, FutVirtualServiceSuperCup.obterResultadoAmbasMarcam");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}

		return null;
	};
	

}
