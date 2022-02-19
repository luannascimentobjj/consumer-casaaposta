package br.casaaposta.main.bind;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.Liga;
import br.casaaposta.main.entity.Odds;
import br.casaaposta.main.entity.Resultado;
import lombok.Data;

@Data
@Component
public class FutServiceBinder {
	
	private int hora;
	private double percent;

	public List<Resultado> bindResultado(LinkedHashMap<Object, Object> resultaForBinding, String tipoResultado) {

		List<Resultado> list = new ArrayList();
		resultaForBinding.entrySet().forEach(entry -> {
			entry.getKey();
			entry.getValue();
			if (entry.getKey().equals("Lines")) {
				ArrayList<LinkedHashMap<Object, Object>> linesArrayOfHash = (ArrayList<LinkedHashMap<Object, Object>>) entry.getValue();
				linesArrayOfHash.forEach(line -> {
					line.entrySet().forEach(subline -> {
						Resultado resultadoRetorno = new Resultado();
						if(subline.getKey().equals("Hora")) {
							this.hora = (int) subline.getValue();
						}
						if(subline.getKey().equals("Percents")) {
							this.percent = (double) subline.getValue();
						}
						if (subline.getKey().equals("Cells")) {
							ArrayList<LinkedHashMap<Object, Object>> cellsArrayOfHash = (ArrayList<LinkedHashMap<Object, Object>>) subline.getValue();
							cellsArrayOfHash.forEach(results -> {
								Resultado r = new Resultado();
								results.entrySet().forEach(result ->{
									if(result.getKey().equals("Minute")) {
										r.setMinuto((int) result.getValue());
									}else if(result.getKey().equals("Tooltip")) {
										if(result.getValue() != null) {
											String[] sub = ((String) result.getValue()).split(" vs ");
											String[] sub2 =  (sub[0]).split(" ");
											r.setTimeVisitante(sub[1]);
											r.setTimeCasa(sub2[3]);
											r.setData(sub2[0]);
											r.setTollTip((String) result.getValue());
										}
									
									}else if(result.getKey().equals("Result")) {
										r.setResultado((String) result.getValue());
									}else if(result.getKey().equals("Countable")) {
										r.setContable((boolean) result.getValue());
									}else if(result.getKey().equals("SumScore")) {
										r.setSumScore((int) result.getValue());
									}
									
								});
								r.setHora(this.hora);
								r.setPercentual(this.percent);
								r.setResultadoTipo(tipoResultado);
								list.add(r);
							});
						}
					});

				});

			}

		});

		return list;

	}
	
	public List<Odds> bindOdds(LinkedHashMap<Object, Object> resultaForBinding, String tipoResultado) {

		List<Odds> list = new ArrayList();
		resultaForBinding.entrySet().forEach(entry -> {
		
				
			
			entry.getKey();
			entry.getValue();
			if (entry.getKey().equals("Lines")) {
				ArrayList<LinkedHashMap<Object, Object>> linesArrayOfHash = (ArrayList<LinkedHashMap<Object, Object>>) entry.getValue();
				linesArrayOfHash.forEach(line -> {
					line.entrySet().forEach(subline -> {
						Odds resultadoRetorno = new Odds();
						if(subline.getKey().equals("Hora")) {
							this.hora = (int) subline.getValue();
						}
						
						if(subline.getKey().equals("Percents")) {
							this.percent = (double) subline.getValue();
						}
						
						if (subline.getKey().equals("Cells")) {
							ArrayList<LinkedHashMap<Object, Object>> cellsArrayOfHash = (ArrayList<LinkedHashMap<Object, Object>>) subline.getValue();
							cellsArrayOfHash.forEach(results -> {
								Odds r = new Odds();
								results.entrySet().forEach(result ->{
									if(result.getKey().equals("Minute")) {
										r.setMinuto((int) result.getValue());
									}else if(result.getKey().equals("Tooltip")) {
										r.setTollTip((String) result.getValue());
									}else if(result.getKey().equals("Result")) {
										r.setResultado((String) result.getValue());
									}else if(result.getKey().equals("Countable")) {
										r.setContable((boolean) result.getValue());
									}else if(result.getKey().equals("SumScore")) {
										r.setSumScore((int) result.getValue());
									}
									
								});
								r.setHora(this.hora);
								r.setPercentual(this.percent);
								r.setResultadoTipo(tipoResultado);
								r.setData(LocalTime.now());
								list.add(r);
							});
						}
					});

				});

			}

		});

		return list;

	}


}
