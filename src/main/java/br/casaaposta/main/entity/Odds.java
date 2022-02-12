package br.casaaposta.main.entity;
import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name="Odds")
@NoArgsConstructor
@Data
public class Odds implements Serializable{
	
	private static final long serialVersionUID = 8511686573089879079L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private Integer Identificador;
	
	@Column(name = "idLiga")
	private Integer idLiga;
	
	@Column(name = "Resultado")
	private String resultado;
	 
	@Column(name = "Partida")
	private String partida;
	 
	@Column(name = "Minuto")
	private String minuto;
	
	@Column(name = "Percentual")
	private String percentual;
	 
	@Column(name = "Hora")
	private String hora;

	@Column(name = "isContable")
	private float isContable;
	

}
