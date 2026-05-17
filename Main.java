import java.util.Scanner;

/**
 * Clase Main: Punto de entrada interactivo de PizzaTrack
 * Permite al usuario agregar, gestionar y visualizar pedidos
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("===== BIENVENIDO A PIZZATRACK =====\n");
        
        gestionpedidos gestor = new gestionpedidos();
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        
        while(opcion != 0) {
            try {
                System.out.println("\n--- MENÚ PRINCIPAL ---");
                System.out.println("1. Agregar pedido");
                System.out.println("2. Ver pedidos activos");
                System.out.println("3. Ver pedidos completados");
                System.out.println("4. Deshacer pedido");
                System.out.println("5. Rehacer pedido");
                System.out.println("6. Vaciar todos los pedidos");
                System.out.println("0. Salir");
                System.out.print("Selecciona opción: ");
                
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch(opcion) {
                    case 1:
                        agregarPedido(gestor, scanner);
                        break;
                    case 2:
                        gestor.mostrarPedidosActivos();
                        break;
                    case 3:
                        gestor.mostrarPedidosCompletados();
                        break;
                    case 4:
                        if(gestor.hayPedidosActivos()) {
                            gestor.deshacerPedido();
                        } else {
                            System.out.println("No hay pedidos para deshacer.");
                        }
                        break;
                    case 5:
                        if(gestor.hayPedidosParaRehacer()) {
                            gestor.rehacerPedido();
                        } else {
                            System.out.println("No hay pedidos para rehacer.");
                        }
                        break;
                    case 6:
                        gestor.vaciarPedidos();
                        break;
                    case 0:
                        System.out.println("\n¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    /**
     * Método auxiliar para agregar un pedido
     */
    private static void agregarPedido(gestionpedidos gestor, Scanner scanner) {
        try {
            System.out.print("Nombre de la pizza: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Precio: $");
            double precio = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.println("Ingresa 3 ingredientes separados por Enter:");
            String[] ing = new String[3];
            for(int i = 0; i < 3; i++) {
                System.out.print("Ingrediente " + (i+1) + ": ");
                ing[i] = scanner.nextLine();
            }
            
            pizza p = new pizza(nombre, precio, ing);
            gestor.agregarpedido(p);
            System.out.println("✓ Pizza agregada correctamente!");
            
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Error inesperado: " + e.getMessage());
        }
    }
}
