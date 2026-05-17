/**
 * Clase Main: Punto de entrada interactivo de PizzaTrack
 * Permite al usuario agregar, gestionar y visualizar pedidos
 */
void main() {
    IO.println("===== BIENVENIDO A PIZZATRACK =====\n");

    gestionpedidos gestor = new gestionpedidos();
    Scanner scanner = new Scanner(System.in);
    int opcion = -1;

    while (opcion != 0) {
        try {
            IO.println("\n--- MENÚ PRINCIPAL ---");
            IO.println("1. Agregar pedido");
            IO.println("2. Ver pedidos activos");
            IO.println("3. Ver pedidos completados");
            IO.println("4. Deshacer pedido");
            IO.println("5. Rehacer pedido");
            IO.println("6. Vaciar todos los pedidos");
            IO.println("0. Salir");
            IO.print("Selecciona opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
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
                    if (gestor.hayPedidosActivos()) {
                        gestor.deshacerPedido();
                    } else {
                        IO.println("No hay pedidos para deshacer.");
                    }
                    break;
                case 5:
                    if (gestor.hayPedidosParaRehacer()) {
                        gestor.rehacerPedido();
                    } else {
                        IO.println("No hay pedidos para rehacer.");
                    }
                    break;
                case 6:
                    gestor.vaciarPedidos();
                    break;
                case 0:
                    IO.println("\n¡Hasta luego!");
                    break;
                default:
                    IO.println("Opción inválida.");
            }
        } catch (Exception e) {
            IO.println("Error: " + e.getMessage());
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
        IO.print("Nombre de la pizza: ");
        String nombre = scanner.nextLine();

        IO.print("Precio: $");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        IO.println("Ingresa 3 ingredientes separados por Enter:");
        String[] ing = new String[3];
        for (int i = 0; i < 3; i++) {
            IO.print("Ingrediente " + (i + 1) + ": ");
            ing[i] = scanner.nextLine();
        }

        pizza p = new pizza(nombre, precio, ing);
        gestor.agregarpedido(p);
        IO.println("✓ Pizza agregada correctamente!");

    } catch (IllegalArgumentException e) {
        IO.println("✗ Error: " + e.getMessage());
    } catch (Exception e) {
        IO.println("✗ Error inesperado: " + e.getMessage());
    }
}
