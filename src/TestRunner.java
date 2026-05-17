/**
 * TestRunner: prueba no interactiva para el proyecto PizzaTrack
 * Ejecuta una secuencia de operaciones para verificar push/pop/undo/redo
 */
public class TestRunner {
    public static void main(String[] args) {
        gestionpedidos gestor = new gestionpedidos();

        String[] ing1 = {"queso", "jamón", "champiñones"};
        pizza p1 = new pizza("Hawaiana", 12.99, ing1);
        gestor.agregarpedido(p1);

        String[] ing2 = {"queso", "pepperoni", "orégano"};
        pizza p2 = new pizza("Pepperoni", 10.50, ing2);
        gestor.agregarpedido(p2);

        System.out.println("\n-- Estado tras agregar 2 pedidos --");
        gestor.mostrarPedidosActivos();

        System.out.println("\n-- Deshacer 1 pedido --");
        gestor.deshacerPedido();

        System.out.println("\n-- Pedidos activos --");
        gestor.mostrarPedidosActivos();

        System.out.println("\n-- Pedidos completados --");
        gestor.mostrarPedidosCompletados();

        System.out.println("\n-- Rehacer 1 pedido --");
        gestor.rehacerPedido();

        System.out.println("\n-- Pedidos activos --");
        gestor.mostrarPedidosActivos();

        System.out.println("\n-- Vaciar pedidos --");
        gestor.vaciarPedidos();

        System.out.println("\n-- Verificar pilas tras vaciar --");
        gestor.mostrarPedidosActivos();
        gestor.mostrarPedidosCompletados();

        System.out.println("\nTestRunner finalizado.");
    }
}
