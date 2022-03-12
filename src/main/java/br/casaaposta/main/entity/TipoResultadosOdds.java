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
@Table(name = "tipo_resultado_odds")
@NoArgsConstructor
@Data
public class TipoResultadosOdds {
	
	public TipoResultadosOdds(String resultadoTipo) {
		this.resultadoTipo = resultadoTipo;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")	
	public int id;
	
	@Column(name ="resultado_tipo")
	private String resultadoTipo;

}
