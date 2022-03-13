package br.casaaposta.main.entity;
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

import br.casaaposta.main.model.OddsModel;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="odds_eurocup")
@NoArgsConstructor
@Data
public class OddsEuroCup extends OddsModel implements Serializable{
	
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
	
	@Column(name="toll_tip")
	private String tollTip;
	
	@Column(name="resultado_tipo")
	private String resultadoTipo;
	
	@Column(name="is_contable")
	private boolean isContable;
	
	@Column(name="sum_score")
	private int sumScore;
	
	@Column(name="time_casa")
	private String timeCasa;
	
	@Column(name="time_visitante")
	private String timeVisitante;
	
	@Column(name="data")
	private String data;
	
	@Column(name="ano")
	private String ano;
	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_liga", referencedColumnName = "cod_liga")
	private Liga codLiga;

}
