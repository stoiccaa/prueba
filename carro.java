import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class carro {

	public static void main(String[] args) {

		ArrayList<String> productos = new ArrayList<>();
		String producto;

		Scanner sc = new Scanner(System.in);

		System.out.println("Inserte un producto (N/A para terminar): ");
		producto = sc.nextLine();
		
		while (!producto.equals("N/A")) {

			productos.add(producto);
			
			System.out.println("Inserte un producto (N/A para terminar): ");
			producto = sc.nextLine();

			System.out.println("Productos en el carro: " +productos);
		}

		sc.close();
	}
}
