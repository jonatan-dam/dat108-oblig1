package dat108_oblig1_oppg1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Oppg1a {
	
	
	
	
	public static void main(String[] args) {
		List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");
		
		Collections.sort(listen, (a, b) -> Integer.compare(Integer.parseInt(a), Integer.parseInt(b)));
			
		for(String tall : listen) {
			System.out.println(tall);
		}
		
		
	}
}
	
	
