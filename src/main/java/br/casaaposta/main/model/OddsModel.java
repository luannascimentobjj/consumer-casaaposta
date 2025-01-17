package br.casaaposta.main.model;
import java.io.Serializable;
import br.casaaposta.main.entity.Liga;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class OddsModel implements Serializable { 
	
	private static final long serialVersionUID = 2709912232043849993L;

	private Integer Id;

	private String resultado;

	private int hora;
	
	private int minuto;

	private double percentual;
	
	private String jogo;
	
	private String tollTip;
	
	private String resultadoTipo;
	
	private boolean isContable;
	
	private int sumScore;
	
	private String timeCasa;
	
	private String timeVisitante;
	
	private String data;
	
	private String ano;
	
	private Liga codLiga;

	

}
