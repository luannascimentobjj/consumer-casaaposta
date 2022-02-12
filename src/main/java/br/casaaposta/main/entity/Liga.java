package br.casaaposta.main.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Liga")
public class Liga implements Serializable {
	

	private static final long serialVersionUID = 2772217429037525001L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	@Getter @Setter
	private int Id;

	@Column(name ="NomeLiga")
	@Getter @Setter
	private String nomeLiga;
	
	@Column(name = "IdOdd")
	@Getter @Setter
	private int idOdd;
	
	@Column(name = "idResultado")
	@Getter @Setter
	private int IdResultado;
}
