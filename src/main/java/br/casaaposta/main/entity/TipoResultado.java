package br.casaaposta.main.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_resultado")
@NoArgsConstructor
@Data
public class TipoResultado {
	
	public TipoResultado(String resultadoTipo, boolean isOdds) {
		this.resultadoTipo = resultadoTipo;
		this.isOdds = isOdds;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")	
	public int id;
	
	@Column(name ="resultado_tipo")
	private String resultadoTipo;
	
	
	@Column(name = "is_odds")
	private boolean isOdds;

}
