package br.casaaposta.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Resultado")
@NoArgsConstructor
@Data
public class Resultado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")	
	private Integer Id;

	@Column(name="Resultado")
	private String resultado;
	
	@Column(name="Hora")
	private int hora;
	
	@Column(name = "Minuto")
	private int minuto;
	
	@Column(name="Percentual")
	private double percentual;
	
	@Column(name="Jogo")
	private String jogo;
	
	@Column(name="TollTip")
	private String tollTip;
	
	@Column(name="ResultadoTipo")
	private String resultadoTipo;
	
	@Column(name="isContable")
	private boolean isContable;
	
	@Column(name="sumScore")
	private int sumScore;
	
	@Column(name="timeCasa")
	private String timeCasa;
	
	@Column(name="timeVisitante")
	private String timeVisitante;
	
	@Column(name="br.casaaposta.main.data")
	private String data;
	
	@Column(name="ano")
	private String ano;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "codLiga", referencedColumnName = "codLiga")
	private Liga codLiga;

}
