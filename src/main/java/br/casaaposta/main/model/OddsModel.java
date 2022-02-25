package br.casaaposta.main.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.casaaposta.main.entity.Liga;
import br.casaaposta.main.entity.Odds;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Data
public class OddsModel implements Serializable { 
	
	private static final long serialVersionUID = 2709912232043849993L;

	private Integer Id;

	private String resultado;

	private int hora;
	
	private int minuto;

	private double percentual;
	
	private String jogo;
	
	private String tollTip;
	
	private String resultadoTipo;
	
	private boolean isContable;
	
	private int sumScore;
	
	private String timeCasa;
	
	private String timeVisitante;
	
	private String data;
	
	private String ano;
	
	private Liga codLiga;

	

}
