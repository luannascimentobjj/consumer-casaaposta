package br.casaaposta.main.service;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import br.casaaposta.main.model.ResultadoModel;
import br.casaaposta.main.util.UrlUtils;

@Service
public class FutVirtualService {

	private final WebClient webClientUnder15;
	private final WebClient webClientResultadoFT;
	UrlUtils urls;
	
	 public FutVirtualService(WebClient.Builder webClientBuilder) {
		this.webClientUnder15 = webClientBuilder.baseUrl(UrlUtils.baseUrl).build();
		this.webClientResultadoFT =  webClientBuilder.baseUrl(UrlUtils.baseUrl).build();
	}
	
	
	public ResultadoModel obterResultadoFT () {
		
		try {
		
			return (ResultadoModel) this.webClientResultadoFT.get();
			
		} catch (Exception e) {
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
