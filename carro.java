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

			System.out.println("Productos en el carro: " + productos);
		}

		String removeOption;
        do {
            System.out.println("¿Desea eliminar algún producto? (Sí/No): ");
            removeOption = sc.nextLine();

            if (removeOption.equalsIgnoreCase("Sí")) { 
                System.out.println("Ingrese el nombre del producto a eliminar: ");
                String productoARemover = sc.nextLine();

                if (productos.contains(productoARemover)) { 
                    productos.remove(productoARemover); 
                    System.out.println("Producto eliminado.");
                } else {
                    System.out.println("El producto no está en el carro.");
                }

                System.out.println("Productos actuales en el carro: " + productos);
            }

        } while (removeOption.equalsIgnoreCase("Sí")); 

        System.out.println("Gracias por usar el carrito. Productos finales: " + productos);

        sc.close();
    }
}
