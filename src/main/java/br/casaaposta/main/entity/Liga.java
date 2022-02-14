package br.casaaposta.main.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="Id")
//	private Integer Id;

	@Id
	@Column(name = "codLiga")
	public String codLiga;
	
	@Column(name ="NomeLiga")
	private String nomeLiga;
	
	
	
	@OneToMany(mappedBy = "codLiga")
	private List<Odds> odds;
	
	@OneToMany(mappedBy = "codLiga")
	private List<Resultado> resultado;
	

}
