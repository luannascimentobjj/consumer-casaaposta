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
import br.casaaposta.main.entity.OddsPremierCup;
import br.casaaposta.main.entity.Resultado;
import br.casaaposta.main.model.OddsModel;
import br.casaaposta.main.repository.LogRepository;
import br.casaaposta.main.repository.ResultadoRepository;
import br.casaaposta.main.util.ConstantsUtils;
import reactor.core.publisher.Mono;

@Service
public class FutVirtualServicePremier {

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

	public FutVirtualServicePremier(WebClient.Builder webClientBuilder) {
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
				.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idPremierCup + ConstantsUtils.baseUnder15FinalUrl).build();
		this.webClientUnder05 = webClientBuilder
				.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idPremierCup + ConstantsUtils.baseUnder05FinalUrl).build();
		this.webClientOver25 = webClientBuilder.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idPremierCup + ConstantsUtils.baseOver25FinalUrl)
				.build();
		this.webClientOver35 = webClientBuilder.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idPremierCup + ConstantsUtils.baseOver35FinalUrl)
				.build();
		this.webClientResultadoFT = webClientBuilder.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idPremierCup + ConstantsUtils.baseFtFinalUrl)
				.build();
		this.webClientResultadoHT = webClientBuilder.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idPremierCup + ConstantsUtils.baseHtFinalUrl)
				.build();
		this.webClientCasa = webClientBuilder.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idPremierCup + ConstantsUtils.baseCasaFinalUrl)
				.build();
		this.webClientEmpate = webClientBuilder.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idPremierCup + ConstantsUtils.baseEmpateFinalUrl)
				.build();
		this.webClientVisitante = webClientBuilder
				.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idPremierCup + ConstantsUtils.baseVisitanteFinalUrl).build();
		this.webClientAmbasMarcam = webClientBuilder
				.baseUrl(ConstantsUtils.baseUrl + ConstantsUtils.idPremierCup + ConstantsUtils.baseAmbasMarcamFinalUrl).build();

	}

	
	public List<Resultado> callServiceResultadoFT(Liga liga) {
		
		try {
			
			
 			Mono<Object> response = this.webClientResultadoFT.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<Resultado> r = futServiceBinder.bindResultado(objects, ConstantsUtils.resultadoFT);
			r.forEach(result -> {
				result.setCodLiga(liga);
			});
			return r;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServicePremier.obterResultadoAmbasMarcam");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}

		return null;
	};

	
	public List<Resultado>  callServiceResultadoHT(Liga liga) {

		try {

			Mono<Object> response = this.webClientResultadoHT.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<Resultado> r = futServiceBinder.bindResultado(objects, ConstantsUtils.resultadoHT);
			r.forEach(result -> {
				result.setCodLiga(liga);
			});
			return r;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServicePremier.obterResultadoHT");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;
	};

	
	public List<OddsPremierCup> callServiceResultadoUnder05(Liga liga) {


		try {
			
			Mono<Object> response = this.webClientUnder05.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, ConstantsUtils.resultadoUnder05);
			List <OddsPremierCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsPremierCup(r, liga);
			return listOddsToReturn;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServicePremier.obterResultadoUnder05");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;
	};

	
	public List<OddsPremierCup> callServiceResultadoUnder15(Liga liga) {

	
		try {
			
			Mono<Object> response = this.webClientUnder15.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, ConstantsUtils.resultadoUnder15);
			List <OddsPremierCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsPremierCup(r, liga);
			return listOddsToReturn;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServicePremier.obterResultadoUnder15");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		
		return null;

	};

	
	public List<OddsPremierCup> callServiceResultadoOver25(Liga liga) {

		
		try {
	
			
			Mono<Object> response = this.webClientOver25.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, ConstantsUtils.resultadoOver25);
			List <OddsPremierCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsPremierCup(r, liga);
			return listOddsToReturn;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServicePremier.obterResultadoOver25");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;
	};

	
	public List<OddsPremierCup> callServiceResultadoOver35(Liga liga) {
	
		try {
			
			Mono<Object> response = this.webClientOver35.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, ConstantsUtils.resultadoOver35);
			List <OddsPremierCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsPremierCup(r, liga);
			return listOddsToReturn;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServicePremier.obterResultadoOver35");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			e.getMessage();
			
		}
		return null;
	};

	
	public List<OddsPremierCup> callServiceResultadoCasa(Liga liga) {

		try {

			
			Mono<Object> response = this.webClientCasa.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, ConstantsUtils.resultadoCasa);
			List <OddsPremierCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsPremierCup(r, liga);
			return listOddsToReturn;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServicePremier.obterResultadoCasa");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}

		return null;
	};

	
	public List<OddsPremierCup> callServiceResultadoEmpate(Liga liga) {

		
		try {
			
			Mono<Object> response = this.webClientEmpate.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, ConstantsUtils.resultadoEmpate);
			List <OddsPremierCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsPremierCup(r, liga);
			return listOddsToReturn;
		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServicePremier.obterResultadoEmpate");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}
		return null;
	};

	
	public List<OddsPremierCup> callServiceResultadoVisitante(Liga liga) {

		
		try {

			
			Mono<Object> response = this.webClientVisitante.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, ConstantsUtils.resultadoVisitante);
			List <OddsPremierCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsPremierCup(r, liga);
			return listOddsToReturn;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServicePremier.obterResultadoVisitante");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}
		return null;
	};

	
	public List<OddsPremierCup> callServiceResultadoAmbasMarcam(Liga liga) {

		
		try {
			
			Mono<Object> response = this.webClientAmbasMarcam.get().retrieve().bodyToMono(Object.class);
			LinkedHashMap<Object, Object> objects = (LinkedHashMap<Object, Object>) response.block();
			List<OddsModel> r = futServiceBinder.bindOdds(objects, ConstantsUtils.resultadoAmbasMarcam);
			List <OddsPremierCup> listOddsToReturn = null;
			listOddsToReturn = futServiceCast.castListOddsPremierCup(r, liga);
			return listOddsToReturn;

		} catch (Exception e) {
			logger_.setStackTrace(e.getMessage());
			logger_.setError("Erro ao coletar informações no site, FutVirtualServicePremier.obterResultadoAmbasMarcam");
			logger_.setDataInclusao(LocalDateTime.now());
			logRepository.save(logger_);
			System.out.println("Erro ao coletar informações no site");
			
		}
		return null;

	};

}
