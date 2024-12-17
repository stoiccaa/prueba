import java.util.Scanner;

public class Prueba {
	
	protected int capacidadTotal;
	protected int[] primera;
	protected int[] segunda;
	protected int numPrimera;
	protected int numSegunda;
	
	protected Scanner sc = new Scanner(System.in);
	
	public Prueba() {  }
	
	public Prueba(int numPrimera2, int numSegunda2) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Prueba miAvion = new Prueba();
		miAvion.invocacion();
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
	protected void menu() {
		
		boolean correcto = false;
		
		do {
			
			  try { 
				  System.out.println
				  ("Indique la cantidad de pasajeros de primera (Al menos 1 y no puede superar 200)");
				  numPrimera = sc.nextInt();
				  
				  if (numPrimera > 0 && numPrimera <= 200) {
					  correcto = true; } 
				  } catch (Exception ex) {this.sc=new Scanner(System.in); }
			} while (!correcto);
		
			correcto = false;
			
			do { 
				
				try {
					System.out.println("Indique la cantidad de pasajeros de segunda ()");
					
					numSegunda = sc.nextInt();
					
					if (numSegunda>=0) {correcto = true;}
					
				}catch (Exception ex) {this.sc=new Scanner(System.in);}
				
				} while (!correcto);
			
			capacidadTotal = numPrimera+numSegunda;
			
			}
			private boolean esMayor(int numero, int[] array, int posicion) {
				if
		   ((posicion>=0)&&(array.length>posicion)&&(numero>array[posicion])) {
					return true;
				}else {
					return false;
				}
			}
			protected void crear() {
				
				primera = new int[numPrimera];
				segunda = new int[capacidadTotal];
			}
			protected void rellenar() {
				int indice = 0;
				System.out.println("Pasajeros de Primera");
				do {
					try {
						System.out.println
						("\tDame el ticket del pasajero " +(indice+1)+ " de primera: ");
						primera[indice]=sc.nextInt();
						
						if ((primera[indice]>-103) && 
							(primera[indice]<103)&&
							(indice==0 || ((indice>0)&&
							(esMayor(primera[indice], primera, indice-1))))) {
							indice++;
						}
						
					}catch (Exception ex) {this.sc=new Scanner(System.in);}
					
				}while (indice<numPrimera);
				System.out.println("Pasajeros de Segunda");
				indice=0;
				
				while (indice<numSegunda) {
					try {
						System.out.print("\tDame el ticket del pasajero "+(indice+1)+" de segunda : ");
						segunda[indice]=sc.nextInt();				
						if ((segunda[indice]>-103) && 
							(segunda[indice]<103)&&
							(indice==0 ||((indice>0)&&
							(esMayor(segunda[indice], segunda, indice-1))))){
							indice++;
						}
					}catch (Exception ex) {this.sc=new Scanner(System.in);}			
				}
			}
			private void desplazarDerecha (int indice) {
				for (int i=segunda.length-1;i>indice;i--) {
					segunda[i]=segunda[i-1];			
				}
			}
			protected void juntarOrdenadosSinUsarOtroArray() {
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
			protected void mostrar(int[] array) {
				for (int indice=0;indice<array.length;indice++) {			
					for (int i=0;i<(8-contarDigitos(array[indice]));i++) {
						System.out.print(" ");
					}
					System.out.print(array[indice]);
				}
				System.out.println("");
			}
			public int getCapacidadTotal() {
				return capacidadTotal;
			}
			public void setCapacidadTotal(int capacidadTotal) {
				this.capacidadTotal = capacidadTotal;
			}
			public int[] getPrimera() {
				return primera;
			}
			public void setPrimera(int[] primera) {
				this.primera = primera;
			}
			public int[] getSegunda() {
				return segunda;
			}
			public void setSegunda(int[] segunda) {
				this.segunda = segunda;
			}
			public int getNumPrimera() {
				return numPrimera;
			}
			public void setNumPrimera(int numPrimera) {
				this.numPrimera = numPrimera;
			}
			public int getNumSegunda() {
				return numSegunda;
			}
			public void setNumSegunda(int numSegunda) {
				this.numSegunda = numSegunda;
			}	
		}
	
