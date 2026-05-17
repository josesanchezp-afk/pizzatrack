/**
 * Clase PilaManual: Implementacion manual de una pila (Stack) generica
 * Utiliza nodos enlazados para almacenar elementos
 */
public class pilamanual<T> {
    
    private nodo<T> cima;      // Puntero a la cima de la pila
    private int tamaño;     // Numero de elementos en la pila

    /**
     * Constructor: Crea una pila vacia
     */
    public pilamanual() {
        cima = null;
        tamaño = 0;
    }

    /**
     * Agrega un elemento a la cima de la pila
     * @param pizza Elemento a agregar
     */
    public void push(T elemento) {
        nodo<T> nuevoNodo = new nodo<>(elemento);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
        tamaño++;
    }

    /**
     * Elimina y retorna el elemento de la cima de la pila
     * @return El elemento en la cima
     * @throws RuntimeException si la pila esta vacia
     */
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia.");
        }
        nodo<T> nodoEliminado = cima;
        cima = cima.siguiente;
        tamaño--;
        return nodoEliminado.elemento;
    }

    /**
     * Retorna el elemento de la cima sin eliminarlo
     * @return El elemento en la cima
     * @throws RuntimeException si la pila esta vacia
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia.");
        }
        return cima.elemento;
    }

    /**
     * Verifica si la pila esta vacia
     * @return true si la pila esta vacia, false en caso contrario
     */
    public boolean isEmpty() {
        return cima == null;
    }

    /**
     * Obtiene el numero de elementos en la pila
     * @return Numero de elementos
     */
    public int size() {
        return tamaño;
    }

    /**
     * Muestra todos los elementos de la pila
     */
    public void mostrartodos() {
        nodo<T> actual = cima;
        int posicion = 1;
        while (actual != null) {
            System.out.println("[" + posicion + "] " + actual.elemento);
            actual = actual.siguiente;
            posicion++;
        }
    }
}
