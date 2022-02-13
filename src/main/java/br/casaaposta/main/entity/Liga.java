package br.casaaposta.main.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Liga")
@NoArgsConstructor
@Data
public class Liga implements Serializable {
	

	private static final long serialVersionUID = 2772217429037525001L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private Integer Id;

	@Column(name = "codLiga")
	private Integer codLiga;
	
	@Column(name ="NomeLiga")
	private String nomeLiga;
	
	@Column(name = "idResultado")
	private int IdResultado;
	
	@OneToOne(mappedBy = "codLiga")
	private Odds odds;
	
	@OneToOne(mappedBy = "codLiga")
	private Resultado resultado;
}
