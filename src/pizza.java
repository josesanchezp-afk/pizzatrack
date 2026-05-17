/**
 * Clase Pizza: Representa una pizza con nombre, ingredientes y precio
 */
public class pizza {
    private final String nombre;
    private final String[] ingredientes;
    private final double precio;

    /**
     * Constructor principal
     * @param nombre Nombre de la pizza
     * @param precio Precio de la pizza
     * @param ingredientes Arreglo de ingredientes (máximo 3)
     */
    public pizza(String nombre, double precio, String[] ingredientes) {
        if (ingredientes == null || ingredientes.length > 3) {
            throw new IllegalArgumentException("Se requieren máximo 3 ingredientes.");
        }
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    /**
     * Constructor alternativo
     */
    public pizza(String nombre, String[] ingredientes, double precio) {
        this(nombre, precio, ingredientes);
    }

    /**
     * Obtiene el nombre de la pizza
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene una copia del arreglo de ingredientes
     */
    public String[] getIngredientes() {
        String[] copia = new String[ingredientes.length];
        System.arraycopy(ingredientes, 0, copia, 0, ingredientes.length);
        return copia;
    }

    /**
     * Obtiene el precio de la pizza
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Representación textual de la pizza
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza: ").append(nombre).append("\n");
        sb.append("Ingredientes: ");
        for (int i = 0; i < ingredientes.length; i++) {
            sb.append(ingredientes[i]);
            if (i < ingredientes.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("\nPrecio: $").append(precio);
        return sb.toString();
    }

    /**
     * Método main para pruebas
     */
    public static void main(String[] args) {
        String[] ingredientes1 = {"queso", "jamón", "champiñones"};
        pizza p1 = new pizza("Hawaiana", 12.99, ingredientes1);
        System.out.println(p1);
        System.out.println();

        String[] ingredientes2 = {"queso", "pepperoni"};
        pizza p2 = new pizza("Pepperoni", ingredientes2, 10.99);
        System.out.println(p2);
    }
}

    
    