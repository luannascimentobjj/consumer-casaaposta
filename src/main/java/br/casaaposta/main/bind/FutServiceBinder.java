package br.casaaposta.main.bind;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.springframework.stereotype.Component;
import br.casaaposta.main.entity.Resultado;
import lombok.Data;

@Data
@Component
public class FutServiceBinder {

	public Resultado bindResultado(LinkedHashMap<Object, Object> resultaForBinding, String tipoResultado) {

		Resultado resultadoRetorno = new Resultado();
		resultadoRetorno.setResultadoTipo(tipoResultado);
		
		resultaForBinding.entrySet().forEach(entry -> {
				
			
			entry.getKey();
			entry.getValue();
			if (entry.getKey().equals("Lines")) {
				ArrayList<LinkedHashMap<Object, Object>> linesArrayOfHash = (ArrayList<LinkedHashMap<Object, Object>>) entry.getValue();
				linesArrayOfHash.forEach(line -> {
					line.entrySet().forEach(subline -> {
						
						if(subline.getKey().equals("Hora")) {
							resultadoRetorno.setHora((int) subline.getValue());
						}
						
						if(subline.getKey().equals("Percents")) {
							resultadoRetorno.setPercentual((double) subline.getValue());
						}
						
						if (subline.getKey().equals("Cells")) {
							ArrayList<LinkedHashMap<Object, Object>> cellsArrayOfHash = (ArrayList<LinkedHashMap<Object, Object>>) subline.getValue();
							cellsArrayOfHash.forEach(results -> {
								results.entrySet().forEach(result ->{
									if(result.getKey().equals("Minute")) {
										resultadoRetorno.setMinuto((int) result.getValue());
									}else if(result.getKey().equals("Tooltip")) {
										resultadoRetorno.setTollTip((String) result.getValue());
									}else if(result.getKey().equals("Result")) {
										resultadoRetorno.setResultado((String) result.getValue());
									}else if(result.getKey().equals("Countable")) {
										resultadoRetorno.setIsContable((float) result.getValue());
									}else if(result.getKey().equals("SumScore")) {
										resultadoRetorno.setSumScore((int) result.getValue());
									}
									
								});
							});
						}
					});

				});

			}

		});

		return resultadoRetorno;

	}

}
