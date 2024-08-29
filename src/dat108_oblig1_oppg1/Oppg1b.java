package dat108_oblig1_oppg1;

import java.util.function.BinaryOperator;

public class Oppg1b {

	public static void main(String[] args) {
		
		BinaryOperator<Integer> summering = (Integer a, Integer b) -> a + b;
		System.out.println("Summen av 12 + 13 = " + beregn(12, 13, summering));
		
		BinaryOperator<Integer> storst = (Integer a, Integer b) -> Math.max(a, b);
		System.out.println("Det største tallet av -5 og 3 er " + beregn(-5, 3, storst));
		
		BinaryOperator<Integer> absolutt = (Integer a, Integer b) -> Math.abs((a-b));
		System.out.println("Absoluttverdien av differansen mellom 54 og 45 er " + beregn(54, 45, absolutt));
		
	}
	
	public static int beregn(int a, int b, BinaryOperator<Integer> handling) {
		return handling.apply(a, b);
	}

}
