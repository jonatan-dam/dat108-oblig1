package dat108_oblig1_oppg2;

import java.util.List;
import java.util.function.Function;

public class Oppg2 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = List.of(
				new Ansatt("Atle", "Patle", Kjonn.MANN, "Engineer", 700000),
				new Ansatt("Per", "Viskeler", Kjonn.MANN, "Sekretær", 400000),
				new Ansatt("Madam", "Felle", Kjonn.KVINNE, "Engineer", 690000),
				new Ansatt("Donald", "Duck", Kjonn.MANN, "Maskott", 100000),
				new Ansatt("Ronald", "McDonald", Kjonn.ANNET, "Sjef", 1500000)
				);
		
		System.out.println("Ansatte før lønnsoppgjør: ");
		skrivUtAlle(ansatte);
		
		
		Function<Ansatt, Integer> kronetillegg = (Ansatt a) -> a.getAarslonn() + 50000;
		lonnsoppgjor(ansatte, kronetillegg);
		System.out.println("\nAnsatte etter lønnsoppgjør med 50 000kr tillegg: ");
		skrivUtAlle(ansatte);
		
		
		
		Function<Ansatt, Integer> prosenttillegg = (Ansatt a) -> (int)(a.getAarslonn()*1.05);
		lonnsoppgjor(ansatte, prosenttillegg);
		System.out.println("\nAnsatte etter lønnsoppgjør med 5% tillegg: ");
		skrivUtAlle(ansatte);
		
		
		Function<Ansatt, Integer> betingetKronetillegg = (Ansatt a) -> {
			if(a.getAarslonn() < 700000) {
				return a.getAarslonn() + 50000;
			} return a.getAarslonn();
		};
		lonnsoppgjor(ansatte, betingetKronetillegg);
		System.out.println("\nAnsatte etter lønnsoppgjør med 50 000kr tillegg hvis du har lønn under 700 000kr: ");
		skrivUtAlle(ansatte);
		
		
		Function<Ansatt, Integer> betingerProsenttillegg = (Ansatt a) -> {
			if(a.getKjonn() == Kjonn.MANN) {
				return (int)(a.getAarslonn() * 1.05);
			} return a.getAarslonn();
		};
		lonnsoppgjor(ansatte, betingerProsenttillegg);
		System.out.println("\nAnsatte etter lønnsoppgjør med 15% tillegg dersom du er mann: ");
		skrivUtAlle(ansatte);
				

	}
	
	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> funksjon) {
		for(Ansatt ansatt : ansatte) {
			ansatt.setAarslonn(funksjon.apply(ansatt));
		}
	}
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		for(Ansatt ansatt : ansatte) {
			System.out.println(ansatt.toString());
		}
	}

}
