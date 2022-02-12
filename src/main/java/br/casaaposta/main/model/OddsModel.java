package br.casaaposta.main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
public class OddsModel { 
	
	@Getter	@Setter 
	private int id;
	
	@Getter	@Setter 
	private int idLiga;
	
	@Getter	@Setter 
	private String resultado;
	 
	@Getter	@Setter 
	private String partida;
	 
	@Getter	@Setter 
	private String minuto;
	
	@Getter	@Setter 
	private String percentual;
	 
	@Getter	@Setter 
	private String hora;

	@Getter	@Setter 
	private float isContable;
	
	

}
