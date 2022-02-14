package br.casaaposta.main.business;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.stereotype.Component;
import br.casaaposta.main.entity.Resultado;
import lombok.Data;

@Data
@Component
public class FutServiceBusiness {

	
	public Resultado bindResultado (LinkedHashMap<Object, Object> objects) {
		
		//Object obj = objects;
		
		objects.entrySet().forEach(entry -> {
			entry.getKey();
			entry.getValue();
			if(entry.getKey().equals("Lines")) {
				Map<Object, Object> lines = (Map<Object, Object>) entry.getValue();
				lines.entrySet().forEach(line -> {
					Class<? extends Object>  liness = line.getClass();
				});
				
			
				
			}
		    
		});
		
		//for (Map.Entry<Object, ArrayList<Object>> entry : objects.entrySet()) {
			//Object key = entry.getKey();
			//Object value = entry.getValue();
			
			
			
		///}
		
		return null;
		
	}
	
}
