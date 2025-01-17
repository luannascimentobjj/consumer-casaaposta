package br.casaaposta.main.bind;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import br.casaaposta.main.entity.Resultado;
import br.casaaposta.main.model.OddsModel;
import lombok.Data;

@Data
@Component
public class FutServiceBinder {

	private int hora;
	private double percent;

	public List<Resultado> bindResultado(LinkedHashMap<Object, Object> resultaForBinding, String tipoResultado) {

		List<Resultado> list = new ArrayList<Resultado>();
		resultaForBinding.entrySet().forEach(entry -> {
			entry.getKey();
			entry.getValue();
			if (entry.getKey().equals("Lines")) {
				ArrayList<LinkedHashMap<Object, Object>> linesArrayOfHash = (ArrayList<LinkedHashMap<Object, Object>>) entry
						.getValue();
				linesArrayOfHash.forEach(line -> {
					line.entrySet().forEach(subline -> {
						Resultado resultadoRetorno = new Resultado();
						if (subline.getKey().equals("Hora")) {
							this.hora = (int) subline.getValue();
						}
						if (subline.getKey().equals("Percents")) {
							this.percent = (double) subline.getValue();
						}
						if (subline.getKey().equals("Cells")) {
							ArrayList<LinkedHashMap<Object, Object>> cellsArrayOfHash = (ArrayList<LinkedHashMap<Object, Object>>) subline
									.getValue();
							cellsArrayOfHash.forEach(results -> {
								Resultado r = new Resultado();
								results.entrySet().forEach(result -> {
									if (result.getKey().equals("Minute")) {
										r.setMinuto((int) result.getValue());
									} else if (result.getKey().equals("Tooltip")) {
										if (result.getValue() != null && result.getValue() != "") {
											String[] sub = ((String) result.getValue()).split(" vs ");
											String[] sub2 = (sub[0]).split(" ");
											r.setTimeVisitante(sub[1]);
											String timeCasa = "";
											if (sub2.length >= 5) {
												if(sub2.length == 5) {
													r.setTimeCasa(sub2[3] + " " + sub2[4]);													
												}else {
													r.setTimeCasa(sub2[3] + " " + sub2[4] + "" + sub2[5]);	
												}
											} else {
												if (sub2[2].length() == 4) {
													r.setTimeCasa(sub2[4]);
												} else {
													r.setTimeCasa(sub2[3]);
												}
											}
											r.setData(sub2[0]);
											r.setAno("2021");
											String mesAux = sub2[0].split("/")[1];
											if (mesAux.equalsIgnoreCase("01") || mesAux.equalsIgnoreCase("02")) {
												r.setAno("2022");
											}

											r.setTollTip((String) result.getValue());
										}

									} else if (result.getKey().equals("Result")) {
										r.setResultado((String) result.getValue());
									} else if (result.getKey().equals("Countable")) {
										r.setContable((boolean) result.getValue());
									} else if (result.getKey().equals("SumScore")) {
										r.setSumScore((int) result.getValue());
									}

								});
								r.setHora(this.hora);
								r.setPercentual(this.percent);
								r.setResultadoTipo(tipoResultado);
								if (r.getTollTip() != null) {
									list.add(r);	
								}
							});
						}
					});

				});

			}

		});

		return list;

	}

	public List<OddsModel> bindOdds(LinkedHashMap<Object, Object> resultaForBinding, String tipoResultado) {

		List<OddsModel> list = new ArrayList<OddsModel>();
		resultaForBinding.entrySet().forEach(entry -> {

			entry.getKey();
			entry.getValue();
			if (entry.getKey().equals("Lines")) {
				ArrayList<LinkedHashMap<Object, Object>> linesArrayOfHash = (ArrayList<LinkedHashMap<Object, Object>>) entry
						.getValue();
				linesArrayOfHash.forEach(line -> {
					line.entrySet().forEach(subline -> {
						OddsModel resultadoRetorno = new OddsModel();
						if (subline.getKey().equals("Hora")) {
							this.hora = (int) subline.getValue();
						}

						if (subline.getKey().equals("Percents")) {
							this.percent = (double) subline.getValue();
						}

						if (subline.getKey().equals("Cells")) {
							ArrayList<LinkedHashMap<Object, Object>> cellsArrayOfHash = (ArrayList<LinkedHashMap<Object, Object>>) subline
									.getValue();
							cellsArrayOfHash.forEach(results -> {
								OddsModel r = new OddsModel();
								results.entrySet().forEach(result -> {
									if (result.getKey().equals("Minute")) {
										r.setMinuto((int) result.getValue());
									} else if (result.getKey().equals("Tooltip")) {
										if (result.getValue() != null && result.getValue() != "") {
											String[] sub = ((String) result.getValue()).split(" vs ");
											String[] sub2 = (sub[0]).split(" ");
											r.setTimeVisitante(sub[1]);
											String timeCasa = "";
											if (sub2.length >= 5) {
												if(sub2.length == 5) {
													r.setTimeCasa(sub2[3] + " " + sub2[4]);													
												}else {
													r.setTimeCasa(sub2[3] + " " + sub2[4] + "" + sub2[5]);	
												}
											} else {
												if (sub2[2].length() == 4) {
													r.setTimeCasa(sub2[4]);
												} else {
													r.setTimeCasa(sub2[3]);
												}
											}
											r.setData(sub2[0]);
											r.setAno("2021");
											String mesAux = sub2[0].split("/")[1];
											if (mesAux.equalsIgnoreCase("01") || mesAux.equalsIgnoreCase("02")) {
												r.setAno("2022");
											}

											r.setTollTip((String) result.getValue());
										}
									} else if (result.getKey().equals("Result")) {
										r.setResultado((String) result.getValue());
									} else if (result.getKey().equals("Countable")) {
										r.setContable((boolean) result.getValue());
									} else if (result.getKey().equals("SumScore")) {
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

}
