package br.casaaposta.main.entity;

import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.*;
import org.hibernate.annotations.Type;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Log")
@NoArgsConstructor
@Data
public class Log implements Serializable{

	private static final long serialVersionUID = -1881318197687385171L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int Id;
	
	@Column(name = "dataInclusao")
	private LocalTime dataInclusao;
	
	@Column(name = "StackTrace")
	@Type(type="text")
	private String stackTrace;
	
	@Column(name = "error")
	private String error;

	
}
