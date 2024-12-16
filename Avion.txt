package Prueba;

import java.util.Scanner;
public class Avion {
	/**
	 * Variable que contiene la capacidad total de pasajeros en el avión
	 */
	private int capacidadTotal;
	
	/**
	 * Variable que contiene un array con los ticket de los pasajeros de primera
	 */
	private int[] primera;
	/**
	 * Variable que contiene un array con los ticket de los pasajeros de segunda + capacidad para los de primera
	 */
	private int[] segunda;	
	
	/**
	 * Variable que contiene el numero de pasajeros de primera
	 */
	private int numPrimera;	
	
	/**
	 * Variable que contiene el numero de pasajeros de segunda
	 */
	private int numSegunda;

	/*
	 * Variable para solicitar parametros por teclado
	 */
	Scanner entrada=new Scanner(System.in);
	
	public Avion(){	}
	
	public static void main (String[] args) {
		Avion miAvion=new Avion();
		miAvion.invocacion();
	}
	
	/**
	 *  Metodo de invocación al proceso de reserva de pasajes en el avión
	 */
	
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
	/**
	 * Metodo que solicita el número de pasajeros de primera y segunda clase y calcula el total en el avión
	 */
	private void menu() {
		boolean correcto=false;
		do {
			try {
				System.out.print("Indique la cantidad de pasajeros de primera (Al menos 1 y No puede superar los 200)");
				numPrimera=entrada.nextInt();				
				if (numPrimera>0 && numPrimera<=200) { correcto=true;}
			}catch (Exception ex) {this.entrada=new Scanner(System.in);}
		}while (!correcto);
		
		correcto=false;
		do {
			try {
			System.out.print("Indique la cantidad de pasajeros de segunda ()");
			numSegunda=entrada.nextInt();
			if (numSegunda>=0) {correcto=true;}
			}catch (Exception ex) {this.entrada=new Scanner(System.in);}
		}while (!correcto);
			
		capacidadTotal=numPrimera+numSegunda;
	}
	/**
	 * Metodo que comprueba si un numero es mayor que el contenido de un array en una posición
	 * @param numero número a comparar
	 * @param array  array de enteros que corresponde con los ticket de los pasajeros.
	 * @param posicion posición en el array a comparar
	 * @return
	 */
	private boolean esMayor(int numero, int[] array, int posicion) {	
		if ((posicion>=0)&&(array.length>posicion)&&(numero>array[posicion])) {
			return true;
		}else {		
			return false;
		}
	}
	/**
	 * Metodo que inicializa los arrays con el número de pasajeros introducido previamente.
	 */
	private void crear() {
		primera=new int[numPrimera];
		segunda=new int[capacidadTotal];		
	}
	/**
	 * Metodo que rellena los ticket de los pasajeros de primera y segunda
	 */
	private void rellenar() {		
		int indice=0;		
		System.out.println("Pasajeros de Primera");
		do {
			try {
				System.out.print("\tDame el ticket del pasajero "+(indice+1)+" de primera : ");
				primera[indice]=entrada.nextInt();				
				if ((primera[indice]>-103) && (primera[indice]<103)&&
						(indice==0 ||((indice>0)&&(esMayor(primera[indice], primera, indice-1))))){
					indice++;
				}
			}catch (Exception ex) {this.entrada=new Scanner(System.in);}		    
		}while (indice<numPrimera);
		System.out.println("Pasajeros de Segunda");
		indice=0;		
		while (indice<numSegunda) {
			try {
				System.out.print("\tDame el ticket del pasajero "+(indice+1)+" de segunda : ");
				segunda[indice]=entrada.nextInt();				
				if ((segunda[indice]>-103) && (segunda[indice]<103)&&
						(indice==0 ||((indice>0)&&(esMayor(segunda[indice], segunda, indice-1))))){
					indice++;
				}
			}catch (Exception ex) {this.entrada=new Scanner(System.in);}			
		}
	}
	/**
	 * Metodo que desplaza todos los elementos de un array hacia la derecha desde un elemento dado como parametro
	 * @param indice elemento desde el cual se desplazara el array
	 */
	private void desplazarDerecha (int indice) {
		for (int i=segunda.length-1;i>indice;i--) {
			segunda[i]=segunda[i-1];			
		}
		
	}
	
	/**
	 * Metodo que fusion dos arrays de enteros en un elemento y los ordena;
	 */
	private void juntarOrdenadosSinUsarOtroArray() {
		int comparador1=0;
		int numSegundo=0;
		for (int i=0; i<segunda.length; i++) {
			if (comparador1<primera.length) {				
				if ((primera[comparador1]<segunda[i])|| (numSegundo==numSegunda)) {
					desplazarDerecha(i);
					segunda[i]=primera[comparador1];
					comparador1++;					
				}else {
					numSegundo++;
				}
			}else {
				break;
			}
		}
	}
	private int contarDigitos(int numero) {
		int digitos=1;
		if (numero<0) {digitos++;numero=numero*(-1);}
		while (numero>=10) {
			numero=numero / 10;
			digitos++;
		}
		return digitos;
	}
	/**
	 * Metodo que muestra por pantalla un array
	 * @param array Array de enteros a mostrar por pantalla
	 */
	private void mostrar(int[] array) {
		for (int indice=0;indice<array.length;indice++) {			
			for (int i=0;i<(8-contarDigitos(array[indice]));i++) {
				System.out.print(" ");
			}
			System.out.print(array[indice]);
		}
		System.out.println("");
	}	
}
