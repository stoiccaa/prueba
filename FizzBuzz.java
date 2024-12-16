package prueba;

public class FizzBuzz {

	/*
	 * Escribe un programa que imprima los números del 1 al 100. Sin embargo, para
	 * los múltiplos de 3, imprime "Fizz" en lugar del número, y para los múltiplos
	 * de 5, imprime "Buzz". Para números que son múltiplos de ambos 3 y 5, imprime
	 * "FizzBuzz".
	 */

	public static void main(String[] args) {

		int i;

		for (i = 1; i < 100; i++)

			if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else {
				System.out.println(i);
			}
	}

}
