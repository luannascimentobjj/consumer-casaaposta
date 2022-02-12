package br.casaaposta.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="Resultado")
@NoArgsConstructor
public class Resultado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")	
	@Getter @Setter 
	private int Id;
	
	@Column(name="IdLiga")
	@Getter @Setter 
	private int IdLiga;
	
	@Column(name="Resultado")
	@Getter @Setter 
	private String resultado;
	
	@Column(name="Data")
	@Getter @Setter 
	private String data;
	
	@Column(name="Jogo")
	@Getter @Setter 
	private String jogo;
	
	@Column(name="ResultadoTipo")
	@Getter @Setter 
	private String resultadoTipo;

}
