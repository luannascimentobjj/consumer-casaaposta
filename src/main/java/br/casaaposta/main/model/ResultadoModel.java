package br.casaaposta.main.model;

import lombok.Getter;
import lombok.Setter;

public class ResultadoModel {

	@Getter @Setter 
	private int Id;
	
	@Getter @Setter 
	private int IdLiga;
	
	@Getter @Setter 
	private String resultado;
	
	@Getter @Setter 
	private String data;
	
	@Getter @Setter 
	private String jogo;
	
	@Getter @Setter 
	private String resultadoTipo;
	
}
