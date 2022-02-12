package br.casaaposta.main.entity;
import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name="Odds")
public class Odds implements Serializable{
	
	private static final long serialVersionUID = 8511686573089879079L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	@Getter @Setter
	private Integer Identificador;
	
	@Column(name = "idLiga")
	@Getter @Setter
	private Integer idLiga;
	
	@Column(name = "Resultado")
	@Getter @Setter
	private String resultado;
	 
	@Column(name = "Partida")
	@Getter @Setter
	private String partida;
	 
	@Column(name = "Minuto")
	@Getter @Setter
	private String minuto;
	
	@Column(name = "Percentual")
	@Getter @Setter
	private String percentual;
	 
	@Column(name = "Hora")
	@Getter @Setter
	private String hora;

	@Column(name = "isContable")
	@Getter @Setter
	private float isContable;
	

}
