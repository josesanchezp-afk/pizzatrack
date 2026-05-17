# MANUAL TÉCNICO - PIZZADIEGO

## 📋 Tabla de Contenidos
1. [Descripción del Proyecto](#descripcion-del-proyecto)
2. [Arquitectura del Sistema](#arquitectura-del-sistema)
3. [Estructura de Clases](#estructura-de-clases)
4. [Patrones de Diseño](#patrones-de-diseño)
5. [Guía de Uso](#guia-de-uso)
6. [Errores Encontrados y Corregidos](#errores-encontrados-y-corregidos)
7. [Mejoras Implementadas](#mejoras-implementadas)

---

## Descripción del Proyecto

**PizzaTrack** es una aplicación Java para gestionar pedidos de pizzas utilizando una estructura de datos tipo **Pila (Stack)**.

### Características principales:
- ✅ Agregar nuevos pedidos
- ✅ Deshacer el último pedido agregado
- ✅ Rehacer pedidos deshechados
- ✅ Visualizar pedidos activos y completados
- ✅ Gestión de pizzas con ingredientes y precios

---

## Arquitectura del Sistema

```
┌─────────────────────────────────────┐
│          MAIN (Punto de entrada)    │
└──────────────┬──────────────────────┘
               │
               ▼
┌─────────────────────────────────────┐
│    GESTIONPEDIDOS (Gestor central)  │
├─────────────────────────────────────┤
│ - pedidosActivos: PilaManual<Pizza> │
│ - pedidosCompletados: PilaManual    │
└──────────────┬──────────────────────┘
               │
       ┌───────┴───────┐
       ▼               ▼
  ┌─────────┐    ┌──────────────┐
  │ PIZZA   │    │ PILAMANUAL   │
  ├─────────┤    ├──────────────┤
  │ nombre  │    │ cima: Nodo   │
  │ precio  │    │ tamaño: int  │
  │ ing[]   │    └──────────────┘
  └─────────┘           │
                        ▼
                   ┌─────────┐
                   │  NODO   │
                   ├─────────┤
                   │ pizza   │
                   │ siguiente
                   └─────────┘
```

---

## Estructura de Clases

### 1. **Pizza.java**
Clase que representa una pizza con sus atributos.

```java
public class pizza {
    private final String nombre;        // Nombre de la pizza (ej: Hawaiana)
    private final String[] ingredientes; // Array de ingredientes (máx 3)
    private final double precio;        // Precio de la pizza
    
    // Métodos públicos
    public String getNombre()
    public String[] getIngredientes()
    public double getPrecio()
    public String toString()
}
```

**Responsabilidades:**
- Almacenar información de la pizza
- Validar que tenga exactamente 3 ingredientes
- Proporcionar representación textual

---

### 2. **Nodo.java**
Clase que representa un nodo en la estructura enlazada de la pila.

```java
public class nodo {
    public pizza pizza;      // Referencia a la pizza almacenada
    public nodo siguiente;   // Referencia al siguiente nodo
    
    public nodo(pizza pizza)
}
```

**Responsabilidades:**
- Almacenar una pizza
- Mantener referencia al siguiente nodo
- Facilitar la navegación entre nodos

---

### 3. **PilaManual.java**
Implementación manual de una estructura de pila (Stack) genérica.

```java
public class pilamanual<T> {
    private nodo cima;      // Puntero a la cima
    private int tamaño;     // Contador de elementos
    
    // Métodos LIFO (Last In First Out)
    public void push(pizza pizza)           // Agregar
    public pizza pop()                      // Eliminar y retornar cima
    public pizza peek()                     // Ver sin eliminar
    public boolean isEmpty()                // Verificar si está vacía
    public int size()                       // Obtener cantidad
    public void mostrartodos()              // Mostrar todos los elementos
}
```

**Principio LIFO:** El último elemento en entrar es el primero en salir.

```
Push (Agregar):        Pop (Eliminar):
    
Elemento3              [vacío]
Elemento2      →       Elemento3
Elemento1              Elemento2
                       Elemento1 (eliminado)
```

---

### 4. **GestionPedidos.java**
Gestor central que controla el flujo de pedidos usando dos pilas.

```java
public class gestionpedidos {
    private pilamanual<pizza> pedidosActivos;      // Pedidos sin completar
    private pilamanual<pizza> pedidosCompletados;  // Pedidos deshechados
    
    // Métodos principales
    public void agregarpedido(pizza pizza)
    public void deshacerPedido()
    public void rehacerPedido()
    public void mostrarPedidosActivos()
    public void mostrarPedidosCompletados()
    public void vaciarPedidos()
    public boolean hayPedidosActivos()
    public boolean hayPedidosParaRehacer()
}
```

**Flujo de operaciones:**
```
Usuario agrega Pedido X
    ↓
Pedido X → pedidosActivos (LIFO)
    ↓
Usuario llama deshacerPedido()
    ↓
Pedido X ← pedidosActivos → pedidosCompletados
    ↓
Usuario llama rehacerPedido()
    ↓
Pedido X ← pedidosCompletados → pedidosActivos
```

---

### 5. **Main.java**
Punto de entrada de la aplicación con demostración de funcionalidad.

---

## Patrones de Diseño

### 1. **Patrón LIFO (Stack)**
- Usado en `GestionPedidos` para gestionar histórico de pedidos
- Permite deshacer y rehacer operaciones
- Similar a: Ctrl+Z / Ctrl+Y en editores

### 2. **Estructura de Datos Enlazada**
- `nodo` mantiene referencias para crear una cadena
- Memoria dinámica (no necesita tamaño fijo)
- Acceso secuencial (O(1) en cima, O(n) en otros)

### 3. **Genéricos Java**
- `pilamanual<T>` puede almacenar cualquier tipo
- Reutilizable para otros tipos de datos

---

## Guía de Uso

### Compilar el proyecto:
```bash
cd src
javac *.java
```

### Ejecutar:
```bash
java Main
```

### Ejemplo de uso programático:

```java
// 1. Crear gestor de pedidos
gestionpedidos gestor = new gestionpedidos();

// 2. Crear una pizza
String[] ingredientes = {"queso", "jamon", "champiñones"};
pizza p1 = new pizza("Hawaiana", 12.99, ingredientes);

// 3. Agregar pedido
gestor.agregarpedido(p1);

// 4. Ver pedidos activos
gestor.mostrarPedidosActivos();

// 5. Deshacer si es necesario
gestor.deshacerPedido();

// 6. Rehacer si es necesario
gestor.rehacerPedido();
```

---

## Errores Encontrados y Corregidos

### ❌ Pizza.java
| Error | Causa | Solución |
|-------|-------|----------|
| `nombre = null` con `final` | Conflicto en constructores | Remover inicialización |
| Métodos dentro de constructor | Anidamiento incorrecto | Mover fuera del constructor |
| `return.String.format()` | Sintaxis rota | Cambiar a `return String.format()` |
| Línea duplicada | Copia accidental | Remover línea extra |

### ❌ GestionPedidos.java
| Error | Causa | Solución |
|-------|-------|----------|
| Constructor duplicado | Copy-paste error | Remover uno |
| Métodos dentro de constructor | Anidamiento incorrecto | Reorganizar estructura |
| `system.out.println()` | Minúscula incorrecta | Cambiar a `System` |
| Indentación caótica | Edición manual defectuosa | Reformatear correctamente |
| Llaves no cerradas | Sintaxis rota | Cerrar todas las llaves |

### ❌ PilaManual.java
| Error | Causa | Solución |
|-------|-------|----------|
| `<cima>` como genérico | Nombre incorrecto de parámetro | Cambiar a `<T>` |
| `Nodo = nodoEliminado = cima` | Sintaxis rota | Cambiar a `nodo nodoEliminado = cima` |
| `RuntimeeException` | Typo | Cambiar a `RuntimeException` |
| `Public` mayúscula | Case sensitivity incorrecto | Cambiar a `public` |
| Métodos no cerrados | Sintaxis rota | Cerrar correctamente |
| Referencia a `Nodo` con mayúscula | Inconsistencia de nombres | Cambiar a `nodo` minúscula |

### ❌ GestionPedidos.java
| Error | Causa | Solución |
|-------|-------|----------|
| Separación de métodos | Métodos anidados | Separar correctamente |

---

## Mejoras Implementadas

### 1. **Documentación JavaDoc completa**
```java
/**
 * Descrición corta
 * 
 * @param nombre Descripción del parámetro
 * @return Descripción del retorno
 * @throws ExceptionType Descripción de excepción
 */
```

### 2. **Manejo de excepciones robusto**
```java
if (isEmpty()) {
    throw new RuntimeException("La pila esta vacia.");
}
```

### 3. **Validación de entrada**
```java
if (ingredientes == null || ingredientes.length > 3) {
    throw new IllegalArgumentException("Se requieren máximo 3 ingredientes.");
}
```

### 4. **Formato de salida mejorado**
```java
System.out.println("\n=== Pedidos Activos ===");
System.out.println("[" + posicion + "] " + actual.pizza);
```

### 5. **Encapsulación correcta**
- Todos los atributos `private final`
- Métodos getter para acceso controlado
- Copias defensivas de arreglos

### 6. **Separación de responsabilidades**
- `Pizza`: Modelo de datos
- `Nodo`: Estructura enlazada
- `PilaManual`: Estructura de datos
- `GestionPedidos`: Lógica de negocio
- `Main`: Presentación

---

## Diagrama de Flujo de Ejecución

```
INICIO
  │
  ├─ Crear GestionPedidos
  │   └─ Inicializar 2 pilas vacías
  │
  ├─ Crear Pizza 1, 2, 3
  │
  ├─ Agregar pedidos (agregarpedido)
  │   └─ Push a pedidosActivos
  │
  ├─ Mostrar pedidos activos
  │   └─ Recorrer pila desde cima
  │
  ├─ Deshacer (deshacerPedido)
  │   └─ Pop de activos → Push a completados
  │
  ├─ Mostrar completados
  │
  ├─ Rehacer (rehacerPedido)
  │   └─ Pop de completados → Push a activos
  │
  └─ FIN
```

---

## Complejidad de Algoritmos

| Operación | Complejidad | Descripción |
|-----------|-------------|------------|
| `push()` | O(1) | Constante: agregar a cima |
| `pop()` | O(1) | Constante: eliminar de cima |
| `peek()` | O(1) | Constante: ver cima |
| `mostrartodos()` | O(n) | Lineal: recorrer n nodos |
| `isEmpty()` | O(1) | Constante: verificar nulo |

---

## Pruebas Sugeridas

```java
// Test 1: Verificar que funciona LIFO
Pizza p1, p2, p3;
gestor.agregarpedido(p1);
gestor.agregarpedido(p2);
gestor.agregarpedido(p3);
assert gestor.pop() == p3;  // Debe ser p3

// Test 2: Verificar deshacerPedido
gestor.deshacerPedido();
assert gestor.hayPedidosActivos() == false;
assert gestor.hayPedidosParaRehacer() == true;

// Test 3: Verificar rehacerPedido
gestor.rehacerPedido();
assert gestor.hayPedidosActivos() == true;

// Test 4: Validar que Pizza rechaza >3 ingredientes
try {
    new pizza("Test", 5.0, new String[4]);
    assert false;  // No debe llegar aquí
} catch (IllegalArgumentException e) {
    assert true;   // Excepción esperada
}
```

---

## Recomendaciones Futuras

1. **Persistencia**: Guardar pedidos en base de datos (SQLite, MySQL)
2. **UI Gráfica**: JavaFX o Swing para interfaz visual
3. **Autenticación**: Usuarios y contraseñas
4. **Reportes**: Generar reportes de ventas
5. **API REST**: Exponer como servicio web (Spring Boot)
6. **Unit Tests**: JUnit para pruebas automatizadas
7. **Logging**: Log4j para registro de eventos

---

## Notas de Mantenimiento

- **Encoding**: UTF-8 para caracteres especiales (ñ, á, etc.)
- **Java Version**: Compatible con Java 8+
- **Build Tool**: Usar Maven o Gradle en proyectos grandes
- **Version Control**: Git para control de cambios

---

**Documento generado por:** Ingeniero en Sistemas  
**Fecha:** 2026-05-17  
**Versión:** 1.0
