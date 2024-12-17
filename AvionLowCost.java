import java.util.Scanner;

public class PruebaLowCost extends Prueba {

	private int[] tercera;
	private int numTercera;

	public PruebaLowCost() {
		super();

	}

	public PruebaLowCost(int numPrimera, int numSegunda, int numTercera) {
		super(numPrimera, numSegunda);
		this.numTercera = numTercera;

	}

	protected void menu() {
		super.menu();

		int superior = numPrimera;
		int inferior = numSegunda;
		if (superior < inferior) {
			superior = numSegunda;
			inferior = numPrimera;
		}

		boolean correcto = false;

		do {

			try {

				System.out.println("Indique la cantidad de pasajeros de tercera(El numero debe estar comprendido entre "
						+ inferior + " y " + superior);
				numTercera = sc.nextInt();
				if (inferior == superior && numTercera == inferior) {
					correcto = true;
				} else if (inferior == (superior + 1) && numTercera == superior) {
					correcto = true;
				} else if (inferior < numTercera && superior > numTercera) {
					correcto = true;
				}
				if (inferior < numTercera && superior > numTercera) {
					correcto = true;
				}
			} catch (Exception ex) {
				this.sc = new Scanner(System.in);
			}
		} while (!correcto);
	}
	
	public void invocacion() {
		menu();
		crear();
		rellenar();
		System.out.println("Primera");
		mostrar(primera);
		System.out.println("Segunda");
		mostrar(segunda);
		System.out.println("Juntos y Ordenados, sin usar otro Array");
		juntarOrdenadosSinUsarOtroArray();
		mostrar(segunda);
	}	
	
	
}
