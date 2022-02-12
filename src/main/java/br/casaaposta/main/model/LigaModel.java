package br.casaaposta.main.model;

import lombok.Getter;
import lombok.Setter;

public class LigaModel {

	@Getter @Setter 
	private int id;
	
	@Getter @Setter 
	private String nomeLiga;
	
	@Getter @Setter 
	private int idOdd;
	
	@Getter @Setter 
	private int IdResultado;
}
