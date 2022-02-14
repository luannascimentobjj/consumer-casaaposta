package br.casaaposta.main.business;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.springframework.stereotype.Component;
import br.casaaposta.main.entity.Resultado;
import lombok.Data;

@Data
@Component
public class FutServiceBusiness {

	public Resultado bindResultado(LinkedHashMap<Object, Object> objects) {

		// Object obj = objects;

		objects.entrySet().forEach(entry -> {
			entry.getKey();
			entry.getValue();
			if (entry.getKey().equals("Lines")) {
				ArrayList<LinkedHashMap<Object, Object>> lines = (ArrayList<LinkedHashMap<Object, Object>>) entry.getValue();
			  	lines.forEach(line -> {
					line.entrySet().forEach(subline -> {
						
						if(subline.getKey().equals("Hora")) {
							//Seta a variavel hora - integer
						}
						
						if(subline.getKey().equals("Percents")) {
							//Seta a variavel Percents - double
						}
						
						if (subline.getKey().equals("Cells")) {
							ArrayList<LinkedHashMap<Object, Object>> results = (ArrayList<LinkedHashMap<Object, Object>>) subline.getValue();
							results.forEach(result -> {
								result.entrySet().forEach(res ->{
									if(res.getKey().equals("Minute")) {
										//seta o resultado - integer
									}else if(res.getKey().equals("Tooltip")) {
										//seta o tooltip - string
									}else if(res.getKey().equals("Result")) {
										//seta o result - string
									}else if(res.getKey().equals("Countable")) {
										//seta o contable - boolean
									}else if(res.getKey().equals("SumScore")) {
										//seta o sumscore - integer
									}
									
								});
							});
						}
					});

				});

			}

		});

		return null;

	}

}
