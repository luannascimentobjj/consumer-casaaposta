package br.casaaposta.main.entity;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



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
	
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "codLiga", referencedColumnName = "codLiga")
	private Liga codLiga;
	

}
