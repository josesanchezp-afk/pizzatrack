/**
 * Clase Nodo: Representa un nodo en la estructura de la pila
 * Es genérico para poder almacenar cualquier tipo de dato
 */
public class nodo<T> {

    // Datos del nodo: elemento genérico
    public T elemento;

    // Referencia al siguiente nodo en la pila
    public nodo<T> siguiente;

    /**
     * Constructor: Crea un nuevo nodo con un elemento
     * @param elemento El elemento a almacenar en el nodo
     */
    public nodo(T elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }
}
