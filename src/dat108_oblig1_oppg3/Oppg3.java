package dat108_oblig1_oppg3;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Oppg3 {

	public static void main(String[] args) {

		List<Ansatt> ansatte = List.of(
				new Ansatt("Atle", "Patle", Kjonn.MANN, "Engineer", 700000),
				new Ansatt("Per", "Viskeler", Kjonn.MANN, "Sekretær", 400000),
				new Ansatt("Madam", "Felle", Kjonn.KVINNE, "Engineer", 690000),
				new Ansatt("Donald", "Duck", Kjonn.MANN, "Maskott", 100000),
				new Ansatt("Ronald", "McDonald", Kjonn.ANNET, "Sjef", 1500000)
				);
		
		//Oppg. a
		List<String> etternavn = ansatte.stream().map(Ansatt::getEtternavn).toList();
		
		for(String e : etternavn) {
			System.out.println(e);
		}
		
		//Oppg. b
		long antallKvinner = ansatte.stream().filter(k -> k.getKjonn() == Kjonn.KVINNE).count();
		System.out.println("\nAntall kvinner blant de ansatte er: " + antallKvinner);
		
		//Oppg. c
		double snittLonnKvinner = ansatte.stream()
				.filter(k -> k.getKjonn() == Kjonn.KVINNE)
				.mapToDouble(k -> k.getAarslonn())
				.average()
				.getAsDouble();
		System.out.println("Snittlønnen blant kvinner er: " + snittLonnKvinner);
		
		//Oppg. d
		ansatte.stream()
			.filter(a -> a.getStilling().toLowerCase().contains("sjef"))
			.forEach(a -> a.setAarslonn((int)(a.getAarslonn() * 1.07)));
		
		ansatte.forEach(System.out::println);
		
		//Oppg. e
		boolean lonnOverBelop = ansatte.stream().anyMatch(a -> a.getAarslonn() > 800000); // Sjekker om det finnes en match på betingelsen i strømmen
		System.out.println("\nDet finnes noen ansatte som tjener mer enn 800.000,- : " + lonnOverBelop);
		
		//Oppg. f
		ansatte.stream().peek(System.out::println).collect(Collectors.toList()); // Bruker .peek istedenfor .forEach her da .forEach lager en løkke
		
		//Oppg. g
		Ansatt lavestLonnet = ansatte.stream().min(Comparator.comparingInt(a -> a.getAarslonn())).orElse(null);
		System.out.println("\nDen lavest lønnet ansatte er: " + lavestLonnet.toString());
		
		//Oppg. h
		int sum = IntStream.range(1, 1000)
				.filter(n -> n % 3 == 0 || n % 5 == 0)
				.sum();
		System.out.println("\nSummen av alle heltall i [1, 1000> som er delelig med 3 eller 5 er " + sum);
	}

}
