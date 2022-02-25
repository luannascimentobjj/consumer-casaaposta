package br.casaaposta.main.entity;
import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="OddsSupercup")
@NoArgsConstructor
@Data
public class OddsSuperCup implements Serializable{
	
	private static final long serialVersionUID = 8511686573089879079L;

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
	
	@Column(name="Data")
	private String data;
	
	@Column(name="ano")
	private String ano;
	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "codLiga", referencedColumnName = "codLiga")
	private Liga codLiga;

}