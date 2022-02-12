package br.casaaposta.main.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Liga")
public class Liga implements Serializable {
	

	private static final long serialVersionUID = 2772217429037525001L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int Id;

	@Column(name ="NomeLiga")
	private String nomeLiga;
	
	@Column(name = "IdOdd")
	private int idOdd;
	
	@Column(name = "idResultado")
	private int IdResultado;
}
