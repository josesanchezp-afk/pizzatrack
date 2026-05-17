/**
 * Clase GestionPedidos: Gestiona pedidos de pizzas usando pilas
 * Permite agregar, deshacer, rehacer y visualizar pedidos
 */
public class gestionpedidos {

    // Pila de pedidos activos - permite deshacer el ultimo pedido
    private pilamanual<pizza> pedidosActivos;
    // Pila de pedidos completados - permite rehacer el ultimo pedido deshecho
    private pilamanual<pizza> pedidosCompletados;

    /**
     * Constructor: Inicializa las pilas de pedidos
     */
    public gestionpedidos() {
        pedidosActivos = new pilamanual<>();
        pedidosCompletados = new pilamanual<>();
    }

    /**
     * Agrega un nuevo pedido a la pila de pedidos activos
     * @param pizza El pedido de pizza a agregar
     */
    public void agregarpedido(pizza pizza) {
        pedidosActivos.push(pizza);
        // Al agregar un nuevo pedido, se invalida la posibilidad de rehacer pedidos anteriores
        while (!pedidosCompletados.isEmpty()) {
            pedidosCompletados.pop();
        }
        System.out.println("Pedido agregado: " + pizza.getNombre());
    }

    /**
     * Deshacer el ultimo pedido activo
     */
    public void deshacerPedido() {
        if (pedidosActivos.isEmpty()) {
            System.out.println("No hay pedidos para deshacer.");
            return;
        }
        pizza pedidoDeshecho = pedidosActivos.pop();
        pedidosCompletados.push(pedidoDeshecho);
        System.out.println("Pedido deshecho: " + pedidoDeshecho.getNombre());
    }

    /**
     * Rehacer el ultimo pedido deshecho
     */
    public void rehacerPedido() {
        if (pedidosCompletados.isEmpty()) {
            System.out.println("No hay pedidos para rehacer.");
            return;
        }
        pizza pedidoRehecho = pedidosCompletados.pop();
        pedidosActivos.push(pedidoRehecho);
        System.out.println("Pedido rehecho: " + pedidoRehecho.getNombre());
    }

    /**
     * Mostrar todos los pedidos activos
     */
    public void mostrarPedidosActivos() {
        if (pedidosActivos.isEmpty()) {
            System.out.println("No hay pedidos activos.");
            return;
        }
        System.out.println("\n=== Pedidos Activos ===");
        pedidosActivos.mostrartodos();
    }

    /**
     * Mostrar todos los pedidos completados
     */
    public void mostrarPedidosCompletados() {
        if (pedidosCompletados.isEmpty()) {
            System.out.println("No hay pedidos completados.");
            return;
        }
        System.out.println("\n=== Pedidos Completados ===");
        pedidosCompletados.mostrartodos();
    }

    /**
     * Vaciar ambas pilas de pedidos
     */
    public void vaciarPedidos() {
        while (!pedidosActivos.isEmpty()) {
            pedidosActivos.pop();
        }
        while (!pedidosCompletados.isEmpty()) {
            pedidosCompletados.pop();
        }
        System.out.println("Todas las pilas de pedidos han sido vaciadas.");
    }

    /**
     * Verificar si hay pedidos activos
     * @return true si hay pedidos activos
     */
    public boolean hayPedidosActivos() {
        return !pedidosActivos.isEmpty();
    }

    /**
     * Verificar si hay pedidos para rehacer
     * @return true si hay pedidos completados
     */
    public boolean hayPedidosParaRehacer() {
        return !pedidosCompletados.isEmpty();
    }
}
